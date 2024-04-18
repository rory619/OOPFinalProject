package ie.atu.standard;

 import java.sql.SQLException;
public interface DatabaseOperations {
    void select() throws SQLException;
    void insert() throws SQLException;
    void update() throws SQLException;
    void delete() throws SQLException;
}
