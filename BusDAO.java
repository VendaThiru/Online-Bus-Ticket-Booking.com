package com.busreservation.dao;

import com.busreservation.db.DBConnection;
import com.busreservation.model.Bus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {
    private Connection conn = DBConnection.getConnection();
    private String busName,source, destination, departureDate;
    private int totalSeats, availableSeats;

//    public void addBus(Bus bus) throws SQLException {
//        String query = "INSERT INTO buses (busName, source, destination, totalSeats, availableSeats, departureDate) VALUES (?, ?, ?, ?, ?, ?)";
//        PreparedStatement stmt = conn.prepareStatement(query);
//        stmt.setString(1, bus.getBusName());
//        stmt.setString(2, bus.getSource());
//        stmt.setString(3, bus.getDestination());
//        stmt.setInt(4, bus.getTotalSeats());
//        stmt.setInt(5, bus.getAvailableSeats());
//        stmt.setString(6, bus.getDepartureDate());
//        stmt.executeUpdate();
//    }
public void addBus(Bus bus) throws SQLException {
    String query = "INSERT INTO buses (busName, source, destination, totalSeats, availableSeats, departureDate) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, bus.getBusName());
        stmt.setString(2, bus.getSource());
        stmt.setString(3, bus.getDestination());
        stmt.setInt(4, bus.getTotalSeats());
        stmt.setInt(5, bus.getAvailableSeats());
        stmt.setString(6, bus.getDepartureDate());

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Bus added successfully.");
        } else {
            System.out.println("Failed to add the bus.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

//    public List<Bus> getAllBuses() throws SQLException {
//        String query = "SELECT * FROM buses";
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(query);
//
//        List<Bus> buses = new ArrayList<>();
//        while (rs.next()) {
//            Bus bus = new Bus(busName, source, destination, totalSeats, availableSeats, departureDate);
//            bus.setBusId(rs.getInt("busId"));
//            bus.setBusName(rs.getString("busName"));
//            bus.setSource(rs.getString("source"));
//            bus.setDestination(rs.getString("destination"));
//            bus.setTotalSeats(rs.getInt("totalSeats"));
//            bus.setAvailableSeats(rs.getInt("availableSeats"));
//            bus.setDepartureDate(rs.getString("departureDate"));
//            buses.add(bus);
//        }
//        return buses;
//    }
public List<Bus> getAllBuses() throws SQLException {
    String query = "SELECT * FROM buses";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);

    List<Bus> buses = new ArrayList<>();
    while (rs.next()) {
        // Create the Bus object and set values retrieved from the ResultSet
        Bus bus = new Bus(busName, source, destination, totalSeats, availableSeats, departureDate);
        bus.setBusId(rs.getInt("busId"));
        bus.setBusName(rs.getString("busName"));
        bus.setSource(rs.getString("source"));
        bus.setDestination(rs.getString("destination"));
        bus.setTotalSeats(rs.getInt("totalSeats"));
        bus.setAvailableSeats(rs.getInt("availableSeats"));
        bus.setDepartureDate(rs.getString("departureDate"));

        buses.add(bus);
    }
    return buses;
}


//    public Bus getBusById(int busId) throws SQLException {
//        String query = "SELECT * FROM buses WHERE busId = ?";
//        PreparedStatement stmt = conn.prepareStatement(query);
//        stmt.setInt(1, busId);
//        ResultSet rs = stmt.executeQuery();
//
//        if (rs.next()) {
//            Bus bus = new Bus(busName, source, destination, totalSeats, availableSeats, departureDate);
//            bus.setBusId(rs.getInt("busId"));
//            bus.setBusName(rs.getString("busName"));
//            bus.setSource(rs.getString("source"));
//            bus.setDestination(rs.getString("destination"));
//            bus.setTotalSeats(rs.getInt("totalSeats"));
//            bus.setAvailableSeats(rs.getInt("availableSeats"));
//            bus.setDepartureDate(rs.getString("departureDate"));
//            return bus;
//        }
//        return null;
//    }
public Bus getBusById(int busId) throws SQLException {
    String query = "SELECT * FROM buses WHERE busId = ?";
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setInt(1, busId);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
        Bus bus = new Bus(busName, source, destination, totalSeats, availableSeats, departureDate);
        bus.setBusId(rs.getInt("busId"));
        bus.setBusName(rs.getString("busName"));
        bus.setSource(rs.getString("source"));
        bus.setDestination(rs.getString("destination"));
        bus.setTotalSeats(rs.getInt("totalSeats"));
        bus.setAvailableSeats(rs.getInt("availableSeats"));
        bus.setDepartureDate(rs.getString("departureDate"));

        return bus;
    }
    return null;
}

    public void updateBus(Bus bus) throws SQLException {
        String query = "UPDATE buses SET busName = ?, source = ?, destination = ?, totalSeats = ?, availableSeats = ?, departureDate = ? WHERE busId = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, bus.getBusName());
        stmt.setString(2, bus.getSource());
        stmt.setString(3, bus.getDestination());
        stmt.setInt(4, bus.getTotalSeats());
        stmt.setInt(5, bus.getAvailableSeats());
        stmt.setString(6, bus.getDepartureDate());
        stmt.setInt(7, bus.getBusId());
        stmt.executeUpdate();
    }

    public void deleteBus(int busId) throws SQLException {
        String query = "DELETE FROM buses WHERE busId = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, busId);
        stmt.executeUpdate();
    }

    public List<Bus> searchBus(String source, String destination, String date) throws SQLException {
        String query = "SELECT * FROM buses WHERE source = ? AND destination = ? AND departureDate = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, source);
        stmt.setString(2, destination);
        stmt.setString(3, date);
        ResultSet rs = stmt.executeQuery();

        List<Bus> buses = new ArrayList<>();
        while (rs.next()) {
            Bus bus = new Bus(busName, source, destination, totalSeats, availableSeats, departureDate);
            bus.setBusId(rs.getInt("busId"));
            bus.setBusName(rs.getString("busName"));
            bus.setSource(rs.getString("source"));
            bus.setDestination(rs.getString("destination"));
            bus.setTotalSeats(rs.getInt("totalSeats"));
            bus.setAvailableSeats(rs.getInt("availableSeats"));
            bus.setDepartureDate(rs.getString("departureDate"));
            buses.add(bus);
        }
        return buses;
    }

    public void updateSeats(int busId, int bookedSeats) throws SQLException {
        String query = "UPDATE buses SET availableSeats = availableSeats - ? WHERE busId = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, bookedSeats);
        stmt.setInt(2, busId);
        stmt.executeUpdate();
    }
}

