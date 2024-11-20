package com.example.DemoProject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
  public  static String url="jdbc:mysql://localhost:3307/anu";
    public static String username="root";
    public static String password="root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
