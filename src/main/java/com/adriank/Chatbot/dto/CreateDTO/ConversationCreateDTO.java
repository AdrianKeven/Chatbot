package com.adriank.Chatbot.dto.CreateDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversationCreateDTO {

    @NotBlank
    private String phoneNumber;

    @NotNull
    private Long botId;
}