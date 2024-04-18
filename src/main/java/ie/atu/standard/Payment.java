package ie.atu.standard;
import java.sql.*;
public class Payment extends DatabaseConnection {
    @Override
    public void select() throws SQLException {
        String selectSQL = "SELECT * FROM payment";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                String custId = resultSet.getString("Customer_Id");
                String amount = resultSet.getString("Amount");
                String paymentType = resultSet.getString("Payment_Type");

                System.out.println("\nCustomer id: " + custId + ", Amount: " + amount + ", Payment type: " + paymentType);
            }
        }
    }

    @Override
    public void insert() throws SQLException {
        try (Connection connection = getConnection();
             // Insert a new record into the "users" table
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO payment (Customer_Id, Amount, Payment_Type) VALUES (?, ?, ?)")) {
            stmt.setString(1, "Richard");
            stmt.setString(2, "5000");
            stmt.setString(3, "Finance");
            stmt.executeUpdate();

            System.out.println("Payment information inserted successfully.");
        }
    }

    @Override
    public void update() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE payment SET Customer_Id = 'Dominic' WHERE Customer_Id = 'Mikey'")) {
            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    @Override
    public void delete() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM payment WHERE Customer_Id = 'Dominic'")) {
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }
    }
}