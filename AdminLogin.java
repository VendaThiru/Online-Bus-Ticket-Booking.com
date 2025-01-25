package com.busreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {

    public static boolean adminLogin(Scanner scanner) {
        System.out.println("==== Admin Login ====");
        System.out.print("Enter Admin Username: ");  // Prompt for username
        String username = scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        String adminPassword = scanner.nextLine();

        if (validateAdminCredentials(username, adminPassword)) {
            System.out.println("Login successful! Redirecting to admin menu...");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    static boolean validateAdminCredentials(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/busreservation";  // Your database URL
        String dbUsername = "root";  // Your MySQL username
        String dbPassword = "Lavanya88380";  // Replace with your actual MySQL root password

        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next();  // Return true if a record is found

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return false;
        }
    }
}