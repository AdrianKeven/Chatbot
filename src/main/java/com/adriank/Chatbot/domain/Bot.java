package com.adriank.Chatbot.domain;

import com.adriank.Chatbot.integration.whatsapp.domain.BotIntent;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bot extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "bot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BotIntent> intents = new ArrayList<>();
}
