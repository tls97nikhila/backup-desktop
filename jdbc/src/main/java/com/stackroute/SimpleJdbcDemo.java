package com.stackroute;

import java.sql.*;
import java.util.Random;

public class SimpleJdbcDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public void getEmployeeDetails() throws SQLException {

        // Load driver and register with DriveManager
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // use DriveManager to  get Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Root@123");

            Statement statement = connection.createStatement();

            ResultSet resultSet= statement.executeQuery("Select * from employeeDetails");

            while (resultSet.next()){
                System.out.println("Id: "+resultSet.getInt(1)+ "  Name :"+resultSet.getString(2)+"     Age "+resultSet.getInt(3)+"    Gender: "+resultSet.getString(4));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

        finally {

            connection.close();
            statement.close();
            resultSet.close();
        }
    }
}
