package com.adriank.Chatbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> health() {

        Map<String, Object> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "Chatbot API");
        status.put("timestamp", LocalDateTime.now());

        return ResponseEntity.ok(status);
    }
}
