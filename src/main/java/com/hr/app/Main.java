package com.hr.app;

import com.hr.app.db.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnection.getInstance();
        Statement statement = connection.createStatement();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
        statement.executeUpdate("create table employee (id number primary key, firstname varchar(25), lastname varchar(25), title varchar(50), division varchar(50), building number, room varchar(25))");
//        statement.executeUpdate("create table emp (id number, name varchar(20), sal number)");
//        statement.executeUpdate("insert into emp (id, name, sal) values (19016, 'Tanver', 70000)");
            System.out.println(connection.hashCode());
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        statement.close();
        connection.close();
    }
}
