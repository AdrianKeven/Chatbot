package com.adriank.Chatbot.integration.whatsapp.domain;

import com.adriank.Chatbot.domain.Bot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class BotIntent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bot_id", nullable = false)
    private Bot bot;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(
            name = "intent_keywords",
            joinColumns = @JoinColumn(name = "intent_id")
    )
    @Column(name = "keyword")
    private List<String> keywords;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String response;

    private boolean active = true;

}
