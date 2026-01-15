package com.adriank.Chatbot.Mapper;

import com.adriank.Chatbot.domain.Bot;
import com.adriank.Chatbot.domain.Conversation;
import com.adriank.Chatbot.dto.CreateDTO.ConversationCreateDTO;
import com.adriank.Chatbot.dto.Summary.BotSummaryDTO;
import com.adriank.Chatbot.dto.DefaultDTO.ConversationDTO;

public class ConversationMapper {

    public static Conversation toEntity(
            ConversationCreateDTO dto,
            Bot bot
    ) {
        Conversation c = new Conversation();
        c.setPhoneNumber(dto.getPhoneNumber());
        c.setBot(bot);
        c.setActive(true); // padrão
        return c;
    }

    public static ConversationDTO toDTO(Conversation c) {
        return new ConversationDTO(
                c.getId(),
                c.getPhoneNumber(),
                c.isActive(),
                new BotSummaryDTO(
                        c.getBot().getId(),
                        c.getBot().getName()
                )
        );
    }
}