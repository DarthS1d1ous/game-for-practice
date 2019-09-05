package com.practice.summer.model.jdbc;

import com.practice.summer.model.user.User;

import java.util.Optional;

public interface UserDao {
    public void save(User user);

    public Optional<User> signIn(String login, String password);
}
