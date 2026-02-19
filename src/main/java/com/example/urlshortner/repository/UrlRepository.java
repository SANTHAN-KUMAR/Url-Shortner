package com.example.urlshortner.repository;

import com.example.urlshortner.model.ShortUrl;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UrlRepository {

    private final Map<String, ShortUrl> storage = new ConcurrentHashMap<>();

    public ShortUrl save(ShortUrl shortUrl) {
        storage.put(shortUrl.getShortCode(), shortUrl);
        return shortUrl;
    }

    public Optional<ShortUrl> findByShortCode(String shortCode) {
        return Optional.ofNullable(storage.get(shortCode));
    }
}
