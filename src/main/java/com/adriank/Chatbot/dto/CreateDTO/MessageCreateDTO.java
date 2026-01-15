package com.adriank.Chatbot.dto.CreateDTO;

import com.adriank.Chatbot.domain.Message.Sender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageCreateDTO {

    private Long conversationId;
    private Sender sender;
    private String content;
}
