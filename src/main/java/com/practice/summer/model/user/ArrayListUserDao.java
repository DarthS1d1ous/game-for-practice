package com.practice.summer.model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListUserDao implements UserDao {
    private Long counter = 0L;

    private List<User> users;

    public ArrayListUserDao() {
        this.users = new ArrayList<>();
    }

    public static ArrayListUserDao getInstance() {
        return SingletonHolder.instance;
    }

    public static class SingletonHolder {
        private static final ArrayListUserDao instance = new ArrayListUserDao();
    }

    @Override
    public synchronized Optional<User> findUser(String login, String password) {
        return users.stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password)).findFirst();
    }

    @Override
    public synchronized boolean addUser(String login, String password) {
        if(findUser(login,password).isPresent()) {
            return false;
        } else {
            User user = new User(login, password);
            user.setId(counter++);
            users.add(user);
            return true;
        }
    }
}
