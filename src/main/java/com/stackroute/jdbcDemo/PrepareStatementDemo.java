package com.stackroute.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrepareStatementDemo {
    public void getEstudentByName(String name)
    {
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Root@123");
            String sql = "select * from estudent where sname=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1,name);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("sno");
                String studentName = result.getString("sname");
                String duration = result.getString("duration");
                System.out.println(id+"\t"+studentName+"\t"+duration);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getEstudentByNameDuration(String name,int duration)
    {
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Root@123");
            String sql = "select * from estudent where sname=? and duration=? ";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,duration);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("sno");
                String studentName = result.getString("sname");
                String durationStudent = result.getString("duration");
                System.out.println(id+"\t"+studentName+"\t"+durationStudent);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
