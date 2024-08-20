package com.cashrich.backend.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cashrich.backend.model.CryptoResponse;
import com.cashrich.backend.repositories.CryptoResponseRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class CryptoService {

    private static final String COINMARKETCAP_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETH,LTC";
    private static final String API_KEY = "27ab17d1-215f-49e5-9ca4-afd48810c149";

    @Autowired
    private CryptoResponseRepository cryptoResponseRepository;

    @Autowired
    private RestTemplate restTemplate;

    public CryptoResponse fetchCryptoData(Long userId) {
        // Set headers
        Map<String, String> headers = new HashMap<>();
        headers.put("X-CMC_PRO_API_KEY", API_KEY);

        // Fetch data from API
        String response = restTemplate.getForObject(COINMARKETCAP_URL, String.class, headers);

        // Create a new CryptoResponse object
        CryptoResponse cryptoResponse = new CryptoResponse();
        cryptoResponse.setUserId(userId);
        cryptoResponse.setApiResponse(response);
        cryptoResponse.setTimestamp(LocalDateTime.now());

        // Save the response to the database
        return cryptoResponseRepository.save(cryptoResponse);
    }
}
