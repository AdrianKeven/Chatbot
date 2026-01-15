package com.adriank.Chatbot.Mapper;

import com.adriank.Chatbot.domain.User;
import com.adriank.Chatbot.dto.CreateDTO.UserCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.UserDTO;
import com.adriank.Chatbot.dto.Summary.UserSummaryDTO;
import com.adriank.Chatbot.dto.Update.UserUpdateDTO;

public class UserMapper {

    private UserMapper() {
        // impede instanciação
    }

    /**
     * CreateDTO → Entity
     */
    public static User toEntity(UserCreateDTO dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword()) // hash no service
                .role(dto.getRole())
                .build();
    }

    /**
     * Entity → DTO
     */
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }

    /**
     * Entity → SummaryDTO
     */
    public static UserSummaryDTO toSummaryDTO(User user) {
        return new UserSummaryDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    /**
     * UpdateDTO → Entity (atualização parcial)
     */
    public static void updateEntity(User user, UserUpdateDTO dto) {
        if (dto.getName() != null) {
            user.setName(dto.getName());
        }

        if (dto.getPassword() != null) {
            user.setPassword(dto.getPassword()); // hash no service
        }
    }
}
