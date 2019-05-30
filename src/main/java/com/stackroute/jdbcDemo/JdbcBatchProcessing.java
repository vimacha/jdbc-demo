package com.stackroute.jdbcDemo;

import java.sql.*;

public class JdbcBatchProcessing {
    public void batchProcessing() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Root@123");
            Statement statement = connection.createStatement();
            // Create statement object
            Statement stmt = connection.createStatement();

// Set auto-commit to false
            connection.setAutoCommit(false);

// Create SQL statement
            String SQL = "INSERT INTO estudent (sno, sname,age,subject,duration) " +
                    "VALUES(17,'rohitHA',45,'os',30)";
// Add above SQL statement in the batch.
            stmt.addBatch(SQL);

// Create one more SQL statement
            SQL = "INSERT INTO estudent (sno, sname,age,subject,duration) " +
                    "VALUES(108,'RajITHA',49,'MP',35)";
// Add above SQL statement in the batch.
            stmt.addBatch(SQL);

// Create one more SQL statement
            SQL = "UPDATE estudent SET sno = 88 " +
                    "WHERE sno = 108";
// Add above SQL statement in the batch.
            stmt.addBatch(SQL);

// Create an int[] to hold returned values
            int[] count = stmt.executeBatch();

//Explicitly commit statements to apply changes
            connection.commit();



            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from estudent");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                System.out.println(name);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

