package com.busreservation.dao;

import com.busreservation.db.DBConnection;
import com.busreservation.model.Booking;

import java.sql.*;

public class BookingDAO {
    private Connection conn = DBConnection.getConnection();

    public void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO bookings (userId, busId, seatsBooked, bookingDate) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, booking.getUserId());
        stmt.setInt(2, booking.getBusId());
        stmt.setInt(3, booking.getSeatsBooked());
        stmt.setString(4, booking.getBookingDate());
        stmt.executeUpdate();
    }

    public Booking getBookingById(int bookingId) throws SQLException {
        String query = "SELECT * FROM bookings WHERE bookingId = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, bookingId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Booking booking = new Booking();
            booking.setBookingId(rs.getInt("bookingId"));
            booking.setUserId(rs.getInt("userId"));
            booking.setBusId(rs.getInt("busId"));
            booking.setSeatsBooked(rs.getInt("seatsBooked"));
            booking.setBookingDate(rs.getString("bookingDate"));
            return booking;
        }
        return null;
    }
}
