package com.adriank.Chatbot.controller;

import com.adriank.Chatbot.Mapper.ConversationMapper;
import com.adriank.Chatbot.dto.CreateDTO.ConversationCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.ConversationDTO;
import com.adriank.Chatbot.service.ConversationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversations")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @PostMapping
    public ResponseEntity<ConversationDTO> create(
            @Valid @RequestBody ConversationCreateDTO dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(conversationService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConversationDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ConversationMapper.toDTO(conversationService.findById(id)));
    }

    @GetMapping("/bot/{botId}")
    public ResponseEntity<List<ConversationDTO>> findByBot(@PathVariable Long botId) {
        return ResponseEntity.ok(conversationService.findByBot(botId));
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable Long id) {
        conversationService.activate(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        conversationService.close(id);
        return ResponseEntity.noContent().build();
    }
}
