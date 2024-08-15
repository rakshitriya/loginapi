package com.cashrich.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashrich.backend.entity.CoinData;

public interface CoinRepository extends JpaRepository<CoinData, Long> {
}