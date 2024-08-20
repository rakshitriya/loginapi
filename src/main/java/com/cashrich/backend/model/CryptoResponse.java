package com.cashrich.backend.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "crypto_responses")
public class CryptoResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "api_response", columnDefinition = "TEXT")
    private String apiResponse;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}
