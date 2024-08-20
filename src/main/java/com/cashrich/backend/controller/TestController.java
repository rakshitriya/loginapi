package com.cashrich.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cashrich.backend.dto.UserDto;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TestController {
    
    @GetMapping("/path")
    public UserDto getMethodName() {
        try{
            UserDto userDto = new UserDto(
                "John",
                "Doe",
                "john.doe@example.com",
                "1234567890",
               "johndoe7",
                "Password@123"
            );

        return userDto;
        }catch(Exception e){
            return null;
        }

    }
    
}
