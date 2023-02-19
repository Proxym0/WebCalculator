package service;

import entity.User;
import storage.InMemoryUsersStorage;

import java.util.Optional;

public class UserService {
    InMemoryUsersStorage userStorage=new InMemoryUsersStorage();

    public void create(User user) {
        userStorage.save(user);
    }
    public Optional<User> findByUserName(String username){
        return userStorage.byUserName(username);}
}