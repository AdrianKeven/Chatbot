package com.adriank.Chatbot.dto.Summary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSummaryDTO {

    public UserSummaryDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    private Long id;
    private String name;
    private String email;
}
