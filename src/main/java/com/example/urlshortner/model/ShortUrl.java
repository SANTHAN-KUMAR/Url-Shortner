package com.example.urlshortner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortUrl {
    private String id;
    private String originalUrl;
    private String shortCode;
    private LocalDateTime createdAt;
}
