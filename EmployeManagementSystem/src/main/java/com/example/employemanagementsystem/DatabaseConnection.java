package com.example.employemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "EMS";
    private static final String PASSWORD = "employee";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    Connection conn = null;
    public Connection connectionMethod(){
        try {
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
