package com.adriank.Chatbot.dto.DefaultDTO;

import com.adriank.Chatbot.dto.Summary.UserSummaryDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotDTO {

    private Long id;
    private String name;
    private String description;

    private UserSummaryDTO owner;

    public BotDTO(Long id, String name, String description, UserSummaryDTO owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
    }
}
