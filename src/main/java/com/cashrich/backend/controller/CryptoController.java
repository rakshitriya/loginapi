package com.cashrich.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.backend.model.CryptoResponse;
import com.cashrich.backend.service.CryptoService;
import com.cashrich.backend.service.UserDetailsImpl;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/fetch")
    public CryptoResponse fetchCryptoData(Authentication authentication) {
        Long userId = ((UserDetailsImpl) authentication.getPrincipal()).getId();
        return cryptoService.fetchCryptoData(userId);
    }
}
