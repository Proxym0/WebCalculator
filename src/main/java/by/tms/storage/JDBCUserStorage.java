package by.tms.storage;

import by.tms.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.tms.storage.Constanta.*;

public class JDBCUserStorage {


    public void saveUser(User user) {
        {

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into users (username,name,password) values (?,?,?) ");
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String> findAllUsername() {
        List<String> usernames = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery("select username from users");
            while (res.next()) {
                usernames.add(res.getString("username"));


            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return usernames;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery("select * from users");
            while (res.next()) {
                String name = res.getString("name");
                String username = res.getString("username");
                String password = res.getString("password");
                User user = new User(username, name, password);
                users.add(user);


            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return users;
    }

}



