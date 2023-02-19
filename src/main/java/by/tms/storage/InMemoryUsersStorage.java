package by.tms.storage;


import by.tms.entity.Operation;
import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUsersStorage {
    //    JDBCOUserStorage storage = new JDBCOUserStorage();
    public List<User> getUsersList() {
        return usersList;
    }

    private List<User> usersList = new ArrayList<>();

    public Optional<Boolean> save(User user) {

        if (usersList.contains(user)) {
            return Optional.of(false);
        }
        usersList.add(user);
        return Optional.of(true);

    }

    public Optional<User> byUserName(String username) {
        for (User user : usersList) {
            if (user.getUserName().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
