package com.codejava.InventoryApp.service;

import com.codejava.InventoryApp.dto.UserRegistrationDTO;
import com.codejava.InventoryApp.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User saveUserRegistration(UserRegistrationDTO userRegistrationDTO);
    void deleteUserById(Long id);
}
