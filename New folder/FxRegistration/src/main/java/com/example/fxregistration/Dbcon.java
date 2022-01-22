package com.example.fxregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {
    private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER="YEAB";
    private static final String PASSWORD="1234";
    private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
    Connection conn=null;
    public Connection connMethod()
    {
        try {
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
