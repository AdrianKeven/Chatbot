package com.adriank.Chatbot.service;

import com.adriank.Chatbot.domain.Conversation;
import com.adriank.Chatbot.domain.Message;
import com.adriank.Chatbot.dto.CreateDTO.MessageCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.MessageDTO;
import com.adriank.Chatbot.Mapper.MessageMapper;
import com.adriank.Chatbot.repository.ConversationRepository;
import com.adriank.Chatbot.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    public MessageDTO create(MessageCreateDTO dto) {

        Conversation conversation = conversationRepository.findById(dto.getConversationId())
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));

        Message message = MessageMapper.toEntity(dto, conversation);

        return MessageMapper.toDTO(messageRepository.save(message));
    }

    public List<MessageDTO> findByConversation(Long conversationId) {

        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));

        return messageRepository.findByConversation(conversation)
                .stream()
                .map(MessageMapper::toDTO)
                .collect(Collectors.toList());
    }
}
