package com.adriank.Chatbot.integration.whatsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WhatsAppSenderService {

    @Value("${whatsapp.token}")
    private String token;

    @Value("${whatsapp.phone-number-id}")
    private String phoneNumberId;

    private final WebClient webClient = WebClient.create();

    public void send(String to, String message) {

        webClient.post()
                .uri("https://graph.facebook.com/v18.0/" + phoneNumberId + "/messages")
                .header("Authorization", "Bearer " + token)
                .bodyValue(Map.of(
                        "messaging_product", "whatsapp",
                        "to", to,
                        "type", "text",
                        "text", Map.of("body", message)
                ))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
