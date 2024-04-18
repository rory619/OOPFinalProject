package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ie.atu.standard.Car;

import java.sql.*;

//import static ie.atu.pool.DatabaseUtils.getConnection;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    private Connection connection;

    @BeforeEach
    public void setup() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinecarstore", "root", "password");
    }
    @AfterEach
    public void complete() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testupdte() throws SQLException
    {
        Car car = new Car();
        car.select();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM car");
        ResultSet resultSet = statement.executeQuery();
        assertTrue(resultSet.next());
    }

    @Test
    public void testInsert() throws SQLException {
        Car car = new Car();

        // Invoke the insert method
        car.insert();

        // Verify by querying the database to check if the inserted record exists
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM car WHERE Car_Id = ?");
        statement.setString(1, "Renault");
        ResultSet resultSet = statement.executeQuery();
        assertTrue(resultSet.next()); // Check if the inserted record is found
    }
    @Test
    public void testUpdate() throws SQLException {
        Car car = new Car();

        // Invoke the update method
        car.update();

        // Verify by querying the database to check if the update was applied correctly
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM car WHERE Car_Id = ?");
        statement.setString(1, "Chevrolet");
        ResultSet resultSet = statement.executeQuery();
        assertTrue(resultSet.next()); // Check if the updated record is found
    }
    @Test
    public void testDelete() throws SQLException {
        Car car = new Car();

        // Invoke the update method
        car.delete();

        // Verify by querying the database to check if the update was applied correctly
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM car WHERE Car_Id = ?");
        statement.setString(1, "Renault");
        ResultSet resultSet = statement.executeQuery();
        assertTrue(resultSet.next()); // Check if the updated record is found
    }

}

