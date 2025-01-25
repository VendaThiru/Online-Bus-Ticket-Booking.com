package com.busreservation.service;

import com.busreservation.dao.BookingDAO;
import com.busreservation.model.Booking;

import java.sql.SQLException;

public class BookingService {
    private BookingDAO bookingDAO = new BookingDAO();

    public void addBooking(Booking booking) {
        try {
            bookingDAO.addBooking(booking);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Booking getBookingById(int bookingId) {
        try {
            return bookingDAO.getBookingById(bookingId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void bookBus(int busId, String userName, String contactNumber, int seatsToBook) {
        
    }
}
