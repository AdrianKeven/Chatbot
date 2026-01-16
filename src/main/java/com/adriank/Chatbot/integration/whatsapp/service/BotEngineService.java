package com.adriank.Chatbot.integration.whatsapp.service;

import com.adriank.Chatbot.domain.Bot;
import com.adriank.Chatbot.integration.whatsapp.domain.BotIntent;
import com.adriank.Chatbot.domain.Conversation;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class BotEngineService {

    public String generateResponse(Conversation conversation, String message) {

        Bot bot = conversation.getBot();
        String normalizedMessage = normalize(message);

        return bot.getIntents().stream()
                .filter(intent ->
                        intent.getKeywords().stream()
                                .map(this::normalize)
                                .anyMatch(normalizedMessage::contains)
                )
                .map(BotIntent::getResponse)
                .findFirst()
                .orElse("Não entendi sua pergunta.");
    }

    private String normalize(String text) {
        return Normalizer.normalize(text.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("[^a-z ]", "");
    }

}
