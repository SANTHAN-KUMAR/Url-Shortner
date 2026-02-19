package com.example.urlshortner.service.idGen;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KeyGenerationService {

    public String generateKey() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
