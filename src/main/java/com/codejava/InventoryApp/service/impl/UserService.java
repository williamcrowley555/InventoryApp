package com.codejava.InventoryApp.service.impl;

import com.codejava.InventoryApp.dto.UserRegistrationDTO;
import com.codejava.InventoryApp.model.Role;
import com.codejava.InventoryApp.model.User;
import com.codejava.InventoryApp.repository.UserRepository;
import com.codejava.InventoryApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User ID: " + id + " does not exist");
        }
        return user;
    }

    @Override
    public User saveUser(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @Override
    public User saveUserRegistration(UserRegistrationDTO userRegistrationDTO) {
        String encodedPassword = encoder.encode(userRegistrationDTO.getPassword());
        userRegistrationDTO.setPassword(encodedPassword);
        User user = convertToModel(userRegistrationDTO);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private User convertToModel(UserRegistrationDTO userRegistrationDTO) {
        return new User(userRegistrationDTO.getEmail(), userRegistrationDTO.getPassword(),
                        userRegistrationDTO.getFirstName(), userRegistrationDTO.getLastName(),
                        true, Set.of(new Role(3L)));
    }
}
