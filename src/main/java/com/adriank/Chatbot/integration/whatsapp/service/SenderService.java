package com.adriank.Chatbot.integration.whatsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class SenderService {

    private final WebClient webClient;

    @Value("${whatsapp.api.url}")
    private String apiUrl;

    @Value("${whatsapp.token}")
    private String token;

    public void sendMessage(String phone, String text) {

        webClient.post()
                .uri(apiUrl + "/messages")
                .header("Authorization", "Bearer " + token)
                .bodyValue(new WhatsAppMessageRequest(phone, text))
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}

