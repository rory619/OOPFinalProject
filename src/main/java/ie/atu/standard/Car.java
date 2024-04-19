package ie.atu.standard;
import java.sql.*;
public class Car extends DatabaseConnection {
    @Override
    public void select() throws SQLException {
        String selectSQL = "SELECT * FROM car";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                String carId = resultSet.getString("Car_Id");
                String engineSize = resultSet.getString("Engine_Size");
                String modelYear = resultSet.getString("Model_Year");
                String mileage = resultSet.getString("Mileage");
                //String selectSQL = "SELECT * FROM car";
                System.out.println("\nCar id: " + carId + ", Engine size: " + engineSize+"Litres" + ", Model year: " + modelYear + ", Mileage: " + mileage);
            }
        }
    }




    @Override
    public void insert() throws SQLException {

        try (Connection connection = getConnection();
             // Insert a new record into the "users" table
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO car (Car_Id, Engine_Size, Model_Year, Mileage) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, "Renault");
            stmt.setString(2, "2.0");
            stmt.setString(3, "2008");
            stmt.setString(4, "290000");
            stmt.executeUpdate();

            System.out.println("Car information inserted successfully.");
        }
    }

    @Override
    public void update() throws SQLException {

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE car SET Car_Id = 'Chevrolet' WHERE Car_Id = 'Renault'")) {
            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    @Override
    public void delete() throws SQLException {

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM car WHERE Car_Id = 'Renault'")) {
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }
    }
}