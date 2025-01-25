package com.busreservation.dao;

import com.busreservation.db.DBConnection;
import com.busreservation.model.User;

import java.sql.*;

public class UserDAO {
    private Connection conn = DBConnection.getConnection();
    private String contactNumber,userName;

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO users (userName, contactNumber) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUserName());
        stmt.setString(2, user.getContactNumber());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            user.setUserId(rs.getInt(1));
        }
    }

    public User getUserById(int userId) throws SQLException {
        String query = "SELECT * FROM users WHERE userId = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            User user = new User(userName, contactNumber);
            user.setUserId(rs.getInt("userId"));
            user.setUserName(rs.getString("userName"));
            user.setContactNumber(rs.getString("contactNumber"));
            return user;
        }
        return null;
    }
}
