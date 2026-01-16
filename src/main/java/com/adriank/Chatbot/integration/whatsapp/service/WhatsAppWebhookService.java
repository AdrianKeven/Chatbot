package com.adriank.Chatbot.integration.whatsapp.service;

import com.adriank.Chatbot.integration.whatsapp.dto.WhatsAppWebhookPayload;
import com.adriank.Chatbot.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WhatsAppWebhookService {

    private final ConversationService conversationService;

    public void processWebhook(WhatsAppWebhookPayload payload) {

        payload.getEntry().forEach(entry ->
                entry.getChanges().forEach(change -> {

                    var messages = change.getValue().getMessages();
                    if (messages == null) return;

                    messages.forEach(message -> {
                        String phone = message.getFrom();
                        String text = message.getText().getBody();

                        // AQUI sim entra seu domínio
                        conversationService.receiveMessage(phone, text);
                    });
                })
        );
    }
}
