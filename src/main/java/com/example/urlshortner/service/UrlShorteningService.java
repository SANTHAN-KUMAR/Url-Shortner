package com.example.urlshortner.service;

import com.example.urlshortner.model.ShortUrl;
import com.example.urlshortner.repository.UrlRepository;
import com.example.urlshortner.service.idGen.KeyGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlShorteningService {

    private final UrlRepository repository;
    private final KeyGenerationService keyGen;

    public ShortUrl shortenUrl(String originalUrl) {
        String key = keyGen.generateKey();
        ShortUrl url = new ShortUrl(key, originalUrl, key, LocalDateTime.now());
        return repository.save(url);
    }

    public String getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode)
                .map(ShortUrl::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}