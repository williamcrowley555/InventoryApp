package com.codejava.InventoryApp.service;

import com.codejava.InventoryApp.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUserById(Long id);
}
