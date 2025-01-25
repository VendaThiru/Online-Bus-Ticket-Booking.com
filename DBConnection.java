package com.busreservation.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/busbookticket"; // Change db name if needed
    private static final String USERNAME = "root"; // Your MySQL username
    private static final String PASSWORD = "Venuthiru@1995"; // Your MySQL password
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Make sure you have the MySQL JDBC driver in your classpath
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connected to the database successfully!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
