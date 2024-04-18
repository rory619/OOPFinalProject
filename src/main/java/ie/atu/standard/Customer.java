package ie.atu.standard;
import java.sql.*;
public class Customer extends DatabaseConnection {
    @Override
    public void select() throws SQLException {
        String selectSQL = "SELECT * FROM customer";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                String custId = resultSet.getString("Customer_Id");
                String storeId = resultSet.getString("Store_Id");
                String addressId = resultSet.getString("Address_Id");
                String email = resultSet.getString("Email");

                System.out.println("\nCustomer id: " + custId + ", Store id: " + storeId + ", Address id: " + addressId + ", Email: " + email);
            }
        }
    }
    @Override
    public void insert() throws SQLException {
        try (Connection connection = getConnection();
             // Insert a new record into the "users" table
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO customer (Car_Id, Engine_Size, Model_Year, Mileage) VALUES (?, ?, ?, ?)")) {
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
             PreparedStatement stmt = connection.prepareStatement("UPDATE customer SET Customer_Id = 'Andy' WHERE Customer_Id = 'Mikey'")) {
            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    @Override
    public void delete() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM customer WHERE Customer_Id = 'Kasey'")) {
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }
    }
}
