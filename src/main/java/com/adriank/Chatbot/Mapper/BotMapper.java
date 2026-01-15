package com.adriank.Chatbot.Mapper;

import com.adriank.Chatbot.domain.Bot;
import com.adriank.Chatbot.domain.User;
import com.adriank.Chatbot.dto.CreateDTO.BotCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.BotDTO;
import com.adriank.Chatbot.dto.Summary.UserSummaryDTO;

public class BotMapper {

    public static Bot toEntity(BotCreateDTO dto, User owner) {
        Bot bot = new Bot();
        bot.setName(dto.getName());
        bot.setDescription(dto.getDescription());
        bot.setOwner(owner);
        return bot;
    }

    public static BotDTO toDTO(Bot bot) {
        return new BotDTO(
                bot.getId(),
                bot.getName(),
                bot.getDescription(),
                new UserSummaryDTO(
                        bot.getOwner().getId(),
                        bot.getOwner().getName(),
                        bot.getOwner().getEmail()
                )
        );
    }

    public static void updateEntity(Bot bot, BotCreateDTO dto) {

        if (dto.getName() != null) {
            bot.setName(dto.getName());
        }

        if (dto.getDescription() != null) {
            bot.setDescription(dto.getDescription());
        }
    }
}
