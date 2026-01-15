package com.adriank.Chatbot.dto.Summary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConversationSummaryDTO {

    private Long id;
    private String phoneNumber;
    private boolean active;
}
