package com.stackroute.jdbcDemo;

import java.sql.*;

public class ResultSetDemo {
    public void getAllStudents() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Root@123");
            PreparedStatement ps = connection.prepareStatement("select * from estudent");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Total columns: " + rsmd.getColumnCount());
            System.out.println("First column name: " + rsmd.getColumnName(1));
            System.out.println("First column datatype: " + rsmd.getColumnTypeName(1));


        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}