package com.hr.app.db;

import java.sql.*;

public class DbConnection {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASSWORD = "12345";

    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            connection = new DbConnection().getConnection();
        }
        return connection;
    }

    private Connection getConnection() {
        Connection con;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }


}
