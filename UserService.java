package com.busreservation.service;

import com.busreservation.dao.UserDAO;
import com.busreservation.model.User;

import java.sql.SQLException;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public void addUser(User user) {
        try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int userId) {
        try {
            return userDAO.getUserById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}