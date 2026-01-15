package com.adriank.Chatbot.service;

import com.adriank.Chatbot.domain.Bot;
import com.adriank.Chatbot.domain.Conversation;
import com.adriank.Chatbot.dto.CreateDTO.ConversationCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.ConversationDTO;
import com.adriank.Chatbot.Mapper.ConversationMapper;
import com.adriank.Chatbot.repository.BotRepository;
import com.adriank.Chatbot.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final BotRepository botRepository;

    public ConversationDTO create(ConversationCreateDTO dto) {

        Bot bot = botRepository.findById(dto.getBotId())
                .orElseThrow(() -> new RuntimeException("Bot não encontrado"));

        Conversation conversation = ConversationMapper.toEntity(dto, bot);

        return ConversationMapper.toDTO(conversationRepository.save(conversation));
    }

    public Conversation findById(Long id) {
        return conversationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));
    }

    public List<ConversationDTO> findByBot(Long botId) {

        Bot bot = botRepository.findById(botId)
                .orElseThrow(() -> new RuntimeException("Bot não encontrado"));

        return conversationRepository.findByBot(bot)
                .stream()
                .map(ConversationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void activate(Long id) {
        Conversation conversation = findById(id);
        conversation.setActive(true);
        conversationRepository.save(conversation);
    }

    public void close(Long id) {
        Conversation conversation = findById(id);
        conversation.setActive(false);
        conversationRepository.save(conversation);
    }

}
