package com.adriank.Chatbot.dto.CreateDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotCreateDTO {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Long ownerId;
}
