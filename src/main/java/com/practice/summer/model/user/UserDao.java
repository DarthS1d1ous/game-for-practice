package com.practice.summer.model.user;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findUser(String login, String password);
    boolean addUser(String login, String password);
}
