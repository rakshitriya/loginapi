package com.cashrich.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.cashrich.backend.model.User;
import com.cashrich.backend.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User userDetails, Authentication authentication) {
        // Get the username of the currently authenticated user
        String username = authentication.getName();
        
        // Set the username on the userDetails object to ensure it matches the authenticated user
        userDetails.setUsername(username);
        
        // Perform the update operation via the service
        User updatedUser = userService.updateUser(userDetails);
        
        // Return the updated user with a 200 OK status
        return ResponseEntity.ok(updatedUser);
    }
}
