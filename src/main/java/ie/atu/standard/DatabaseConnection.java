package ie.atu.standard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public abstract class DatabaseConnection implements DatabaseOperations {
    protected Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/onlinecarstore";
        String username = "root";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }
}