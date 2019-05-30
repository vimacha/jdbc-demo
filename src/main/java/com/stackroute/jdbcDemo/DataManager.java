package com.stackroute.jdbcDemo;

import java.sql.*;

public class DataManager {

    public void getAllStudents(){

        try {

            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Root@123" );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from estudent");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println(id);

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }


}