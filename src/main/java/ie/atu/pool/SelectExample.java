package ie.atu.pool;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {
        String selectSQL = "SELECT h.FirstName, h.LastName " +
                "FROM human h " +
                "JOIN animal a ON breed = a.user_id";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String user = resultSet.getString("First name");
                String pass = resultSet.getString("Last name");


                System.out.println("first name: " + user + ", last name: " + pass );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
