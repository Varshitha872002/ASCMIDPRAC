package com.midex.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mid", "root", "mysql");
                System.out.println("Connection established");
            }
            catch (ClassNotFoundException | SQLException sqlexception) {
                sqlexception.printStackTrace();
            }
        }
        return connection;
    }
}
