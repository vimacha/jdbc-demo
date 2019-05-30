package com.stackroute.jdbcDemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMetDataDemo {
    public void getDatabaseMetaData() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student", "root", "Root@123");
            DatabaseMetaData databaseMetaData = con.getMetaData();

            System.out.println("Driver Name: " + databaseMetaData.getDriverName());
            System.out.println("Driver Version: " + databaseMetaData.getDriverVersion());
            System.out.println("UserName: " + databaseMetaData.getUserName());
            System.out.println("Database Product Name: " + databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + databaseMetaData.getDatabaseProductVersion());

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
