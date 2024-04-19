package ie.atu.standard;
import java.sql.*;
public class Store extends DatabaseConnection {
    @Override
    public void select() throws SQLException {
        String selectSQL = "SELECT * FROM store";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                String Email = resultSet.getString("Email");
                String Number = resultSet.getString("Phone_Number");
                String Owner = resultSet.getString("Owner_Id");
                System.out.println("\nEmail: " + Email + ", Phone number: " + Number + ", owner: " + Owner);
            }
        }
    }

    @Override
    public void insert() throws SQLException {
        try (Connection connection = getConnection();
             // Insert a new record into the "users" table
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO store (Email, Phone_Number, Owner_Id) VALUES (?, ?,?)")) {
            stmt.setString(1, "Lisa@gmail.com");
            stmt.setString(2, "087335220");
            stmt.setString(3, "Peter");
            stmt.executeUpdate();

            System.out.println("Insert completed successfully.");
        }
    }

    @Override
    public void update() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE store SET Email = 'Mark@gmail.com' WHERE Email = 'Lisa@gmail.com'"))
        {
            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    @Override

    public void delete() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM store WHERE Email = 'Mark@gmail.com'")) {
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);

        }
    }
}