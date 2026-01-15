package com.adriank.Chatbot.dto.DefaultDTO;

import com.adriank.Chatbot.dto.Summary.BotSummaryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConversationDTO {

    private Long id;
    private String phoneNumber;
    private boolean active;

    private BotSummaryDTO bot;
}

