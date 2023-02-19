package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.InMemoryUsersStorage;

import java.util.List;
import java.util.Optional;

public class UserService {
    public static final UserService USER_SERVICE=new UserService();
    InMemoryUsersStorage userStorage = new InMemoryUsersStorage();


    public void create(User user) {
        userStorage.save(user);
    }

    public Optional<User> findByUserName(String username) {
        return userStorage.byUserName(username);
    }

    public Optional<User> create(String userName, String name, String password) {
        User user = new User(userName, name, password);
        Optional<Boolean> save = userStorage.save(user);
        if (save.isEmpty() || !save.get()) {
            return Optional.empty();
        }
        return Optional.of(user);
    }
    public List<User> findAll(){
        return userStorage.getUsersList();
    }

}