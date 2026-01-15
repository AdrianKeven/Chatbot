package com.adriank.Chatbot.controller;

import com.adriank.Chatbot.Mapper.BotMapper;
import com.adriank.Chatbot.dto.CreateDTO.BotCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.BotDTO;
import com.adriank.Chatbot.service.BotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bots")
@RequiredArgsConstructor
public class BotController {

    private final BotService botService;

    @PostMapping
    public ResponseEntity<BotDTO> create(@Valid @RequestBody BotCreateDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(botService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BotDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(BotMapper.toDTO(botService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<BotDTO>> findAll() {
        return ResponseEntity.ok(botService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BotDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody BotCreateDTO dto
    ) {
        return ResponseEntity.ok(botService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        botService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
