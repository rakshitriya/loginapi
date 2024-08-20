package com.cashrich.backend.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashrich.backend.model.User;
import com.cashrich.backend.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User updateUser(User updatedUser) {
        Optional<User> optionalUser = userRepository.findByUsername(updatedUser.getUsername());

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Update user details
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setMobile(updatedUser.getMobile());

            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                existingUser.setPassword(updatedUser.getPassword());
            }

            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}

