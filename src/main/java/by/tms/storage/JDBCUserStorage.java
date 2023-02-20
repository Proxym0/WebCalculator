package by.tms.storage;

import by.tms.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUserStorage {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";

    public void saveUser(User user) {
        {

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into operations values (default,?,?,?) ");
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
