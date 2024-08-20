package com.cashrich.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cashrich.backend.model.CryptoResponse;

@Repository
public interface CryptoResponseRepository extends JpaRepository<CryptoResponse, Long> {
}
