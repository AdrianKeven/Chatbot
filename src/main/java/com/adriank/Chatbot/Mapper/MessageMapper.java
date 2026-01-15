package com.adriank.Chatbot.Mapper;

import com.adriank.Chatbot.domain.Conversation;
import com.adriank.Chatbot.domain.Message;
import com.adriank.Chatbot.dto.CreateDTO.MessageCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.MessageDTO;
import com.adriank.Chatbot.dto.Summary.ConversationSummaryDTO;

public class MessageMapper {

    private MessageMapper() {
        // evita instanciação
    }

    public static MessageDTO toDTO(Message message) {
        return new MessageDTO(
                message.getId(),
                message.getSender(),
                message.getContent(),
                new ConversationSummaryDTO(
                        message.getConversation().getId(),
                        message.getConversation().getPhoneNumber(),
                        message.getConversation().isActive()
                )
        );
    }

    public static Message toEntity(MessageCreateDTO dto, Conversation conversation) {
        return Message.builder()
                .conversation(conversation)
                .sender(dto.getSender())
                .content(dto.getContent())
                .build();
    }

}
