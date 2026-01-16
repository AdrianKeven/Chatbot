package com.adriank.Chatbot.integration.whatsapp.controller;

import com.adriank.Chatbot.integration.whatsapp.dto.WhatsAppWebhookPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhooks/whatsapp")
public class WhatsAppWebhookController {

    @Value("${whatsapp.verify-token}")
    private String verifyToken;

    @GetMapping
    public ResponseEntity<String> verify(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String token
    ) {
        if ("subscribe".equals(mode) && verifyToken.equals(token)) {
            return ResponseEntity.ok(challenge);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    @PostMapping
    public ResponseEntity<Void> receive(@RequestBody WhatsAppWebhookPayload payload) {

        payload.getEntry().forEach(entry ->
                entry.getChanges().forEach(change -> {

                    var messages = change.getValue().getMessages();
                    if (messages == null) return;

                    messages.forEach(msg -> {
                        String phone = msg.getFrom();
                        String text = msg.getText().getBody();

                        // aqui você chama:
                        // conversationService.receiveMessage(phone, text);
                    });
                })
        );

        return ResponseEntity.ok().build();
    }
}