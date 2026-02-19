package com.example.urlshortner.controller;

import com.example.urlshortner.model.ShortUrl;
import com.example.urlshortner.service.UrlShorteningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlShorteningService service;

    @PostMapping("/shorten")
    public ShortUrl shortenUrl(@RequestParam String url) {
        return service.shortenUrl(url);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String shortCode) {
        String originalUrl = service.getOriginalUrl(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}
