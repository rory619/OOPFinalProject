package ie.atu.standard;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {
        // MySQL database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        // SQL statement
        String selectSQL = "SELECT u.FirstName, u.LastName " +
                "FROM animal a " +
                "JOIN human h ON u.id = e.user_id";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String user = resultSet.getString("FirstName");
                String pass = resultSet.getString("LastName");


                System.out.println("First name: " + user + ", Last name: " + pass );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
