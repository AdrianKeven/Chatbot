package com.adriank.Chatbot.dto.DefaultDTO;

import com.adriank.Chatbot.domain.Message.Sender;
import com.adriank.Chatbot.dto.Summary.ConversationSummaryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageDTO {

    private Long id;
    private Sender sender;
    private String content;
    private ConversationSummaryDTO conversation;
}
