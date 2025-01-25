package com.busreservation.service;

import com.busreservation.dao.BusDAO;
import com.busreservation.model.Bus;

import java.sql.SQLException;
import java.util.List;

public class BusService {
    private BusDAO busDAO = new BusDAO();

    public void addBus(Bus bus) {
        try {
            busDAO.addBus(bus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bus> getAllBuses() {
        try {
            return busDAO.getAllBuses();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bus getBusById(int busId) {
        try {
            return busDAO.getBusById(busId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBus(Bus bus) {
        try {
            busDAO.updateBus(bus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBus(int busId) {
        try {
            busDAO.deleteBus(busId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bus> searchBus(String source, String destination, String date) {
        try {
            return busDAO.searchBus(source, destination, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSeats(int busId, int bookedSeats) {
        try {
            busDAO.updateSeats(busId, bookedSeats);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
