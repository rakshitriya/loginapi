package com.cashrich.backend.model;


import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 10, max = 15)
    private String mobile;

    @NotBlank
    @Size(min = 4, max = 15)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric")
    @Column(unique = true)
    private String username;

    @NotBlank
    //@Size(min = 64, max = 128)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$", 
             message = "Password must have at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;

}
