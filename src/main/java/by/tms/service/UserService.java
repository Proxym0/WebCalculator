package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.InMemoryUsersStorage;
import by.tms.storage.JDBCUserStorage;

import java.util.List;
import java.util.Optional;

public class UserService {
    public static final UserService USER_SERVICE = new UserService();
    InMemoryUsersStorage userStorage = new InMemoryUsersStorage();
    JDBCUserStorage storage = new JDBCUserStorage();

    public Optional<User> findByUserName(String username) {
        return userStorage.byUserName(username);
    }

    public Optional<User> create(String userName, String name, String password) {
        User user = new User(userName, name, password);
        List<String> allUsername = storage.findAllUsername();
        if (allUsername.contains(userName)) {
            return Optional.empty();
        }
        storage.saveUser(user);
        return Optional.of(user);
    }


    public List<User> findAll() {
        return storage.findAll();
    }


}