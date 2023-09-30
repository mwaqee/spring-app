package com.mwaqee.spring.auth.service;

import com.mwaqee.spring.auth.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> getAllUsers();
    
    boolean validRoleId(String role);
}
