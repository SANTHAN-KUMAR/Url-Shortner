package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saruku")
    public String sayHello() {
        return "Hello, World!... this is saruku mutti";
    }
}