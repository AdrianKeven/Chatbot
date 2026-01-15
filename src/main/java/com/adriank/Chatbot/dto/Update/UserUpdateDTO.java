package com.adriank.Chatbot.dto.Update;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {

    private String name;

    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    private String password;
}
