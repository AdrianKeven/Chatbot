package com.adriank.Chatbot.dto.DefaultDTO;

import com.adriank.Chatbot.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private Role role;
}
