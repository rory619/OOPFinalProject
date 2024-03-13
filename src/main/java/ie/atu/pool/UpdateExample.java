package ie.atu.pool;

import java.sql.*;

public class UpdateExample {
    public static void main(String[] args) {
        String updateSQL = "UPDATE users SET FirstName = 'newname' WHERE FirstName = 'Rory'";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement()) {
            int rowsUpdated = statement.executeUpdate(updateSQL);
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
