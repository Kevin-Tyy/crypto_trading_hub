package com.tradeflow.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
    private Connection connection;
    private final String DB_NAME = "tradeflow";
    private final String PASSWORD = "qwerty123";
    private final String USERNAME = "postgres";


    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/";
            conn = DriverManager.getConnection(url + DB_NAME, USERNAME, PASSWORD);
            if (conn != null)
                System.out.println("We are connected to the database successfully");
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("SQL Exception", e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            throw new SQLException("JDBC Driver not found", e);
        }
        return conn;
    }

}
