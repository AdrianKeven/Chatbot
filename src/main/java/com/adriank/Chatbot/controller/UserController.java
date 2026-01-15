package com.adriank.Chatbot.controller;

import com.adriank.Chatbot.Mapper.UserMapper;
import com.adriank.Chatbot.dto.CreateDTO.UserCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.UserDTO;
import com.adriank.Chatbot.dto.Summary.UserSummaryDTO;
import com.adriank.Chatbot.dto.Update.UserUpdateDTO;
import com.adriank.Chatbot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Criar usuário
     */
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserCreateDTO dto) {
        UserDTO createdUser = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Buscar usuário por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO user = UserMapper.toDTO(userService.findById(id));
        return ResponseEntity.ok(user);
    }

    /**
     * Listar usuários
     */
    @GetMapping
    public ResponseEntity<List<UserSummaryDTO>> findAll() {
        List<UserSummaryDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    /**
     * Atualizar usuário
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(
            @PathVariable Long id,
            @RequestBody UserUpdateDTO dto
    ) {
        UserDTO updatedUser = userService.update(id, dto);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Deletar usuário
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
