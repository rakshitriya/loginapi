package com.cashrich.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.backend.entity.CoinData;
import com.cashrich.backend.service.CoinService;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @GetMapping("/data")
    public ResponseEntity<CoinData> getCoinData(@RequestParam Long userId) {
        CoinData coinData = coinService.getCoinData(userId);
        return ResponseEntity.ok(coinData);
    }
}