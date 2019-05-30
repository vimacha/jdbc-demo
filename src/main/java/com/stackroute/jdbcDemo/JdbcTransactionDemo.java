package com.stackroute.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTransactionDemo {
    public void transactionData() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Root@123");
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into estudent values(8,'ajay',23,'dbms',13)");
            stmt.executeUpdate("insert into estudent values(9,'jay',24,'os',15)");

            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
