package com.tradeflow.dao;

import com.tradeflow.models.User;

import java.util.UUID;

public interface UserDao {
    boolean createUser(User user);
    User getUserByUserId(UUID userId);
    User getUserByEmail (String email);
    User getUserByUsername (String username);

    boolean checkUserExistsByUsername(String username);
    boolean checkUserExistsByEmail(String email);
    boolean checkUserExistsById(UUID userId);

}