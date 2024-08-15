package com.cashrich.backend.entity;


import com.cashrich.backend.validations.ValidPassword;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Size(min = 4, max = 15)
    private String username;

    @Column(nullable = false)
    @Size(min = 8, max = 15)
    @ValidPassword
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    private String mobile;
}
