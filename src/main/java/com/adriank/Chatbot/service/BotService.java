package com.adriank.Chatbot.service;

import com.adriank.Chatbot.domain.Bot;
import com.adriank.Chatbot.domain.Conversation;
import com.adriank.Chatbot.domain.User;
import com.adriank.Chatbot.dto.CreateDTO.BotCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.BotDTO;
import com.adriank.Chatbot.Mapper.BotMapper;
import com.adriank.Chatbot.integration.whatsapp.domain.BotIntent;
import com.adriank.Chatbot.repository.BotRepository;
import com.adriank.Chatbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BotService {

    private final BotRepository botRepository;
    private final UserRepository userRepository;

    public BotDTO create(BotCreateDTO dto) {

        User owner = userRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner não encontrado"));

        Bot bot = BotMapper.toEntity(dto, owner);

        return BotMapper.toDTO(botRepository.save(bot));
    }

    public Bot findById(Long id) {
        return botRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bot não encontrado"));
    }

    public List<BotDTO> findAll() {
        return botRepository.findAll()
                .stream()
                .map(BotMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BotDTO update(Long id, BotCreateDTO dto) {
        Bot bot = findById(id);
        BotMapper.updateEntity(bot, dto);
        return BotMapper.toDTO(botRepository.save(bot));
    }

    public void delete(Long id) {
        botRepository.delete(findById(id));
    }

    public String generateResponse(Conversation conversation, String message) {

        String normalizedMessage = normalize(message);

        return conversation.getBot().getIntents().stream()
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
        return java.text.Normalizer.normalize(text, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }
}
