package com.adriank.Chatbot.controller;

import com.adriank.Chatbot.dto.CreateDTO.MessageCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.MessageDTO;
import com.adriank.Chatbot.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageDTO> create(
            @Valid @RequestBody MessageCreateDTO dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(messageService.create(dto));
    }

    @GetMapping("/conversation/{conversationId}")
    public ResponseEntity<List<MessageDTO>> findByConversation(
            @PathVariable Long conversationId
    ) {
        return ResponseEntity.ok(
                messageService.findByConversation(conversationId)
        );
    }
}
