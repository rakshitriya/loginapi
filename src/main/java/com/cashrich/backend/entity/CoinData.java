package com.cashrich.backend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.Data;

@Data
@Entity
public class CoinData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Lob
    private String response;

    private LocalDateTime timestamp;
}
