package com.cashrich.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cashrich.backend.dto.UserDto;
import com.cashrich.backend.model.User;
import com.cashrich.backend.repositories.UserRepository;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserDto userDto) {
        Optional<User> userByUsername = userRepository.findByUsername(userDto.getUsername());
        Optional<User> userByEmail = userRepository.findByEmail(userDto.getEmail());

        if (userByUsername.isPresent() || userByEmail.isPresent()) {
            throw new RuntimeException("Username or Email already taken");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMobile(userDto.getMobile());

        return userRepository.save(user);
    }
}
