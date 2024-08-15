package com.cashrich.backend.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cashrich.backend.entity.CoinData;
import com.cashrich.backend.repository.CoinRepository;

@Service
public class CoinService {

    private static final String API_KEY = "27ab17d1-215f-49e5-9ca4-afd48810c149";
    private static final String API_URL = "https://proapi.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETH,LTC";

    @Autowired
    private CoinRepository coinRepository;

    public CoinData getCoinData(Long userId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class);

        CoinData coinData = new CoinData();
        coinData.setUserId(userId);
        coinData.setResponse(response.getBody());
        coinData.setTimestamp(LocalDateTime.now());
        coinRepository.save(coinData);

        return coinData;
    }
}