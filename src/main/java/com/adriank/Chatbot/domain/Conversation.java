package com.adriank.Chatbot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conversations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Número do WhatsApp (identificador externo da conversa)
     */
    @Column(nullable = false, length = 20)
    private String phone;

    /**
     * Bot responsável por responder
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bot_id", nullable = false)
    private Bot bot;

    /**
     * Status da conversa
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConversationStatus status;

    /**
     * Histórico de mensagens
     */
    @OneToMany(
            mappedBy = "conversation",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Message> messages = new ArrayList<>();

    /**
     * Controle de tempo
     */
    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime closedAt;

    /* =========================
       MÉTODOS DE DOMÍNIO
       ========================= */

    public void activate() {
        this.status = ConversationStatus.ACTIVE;
    }

    public void close() {
        this.status = ConversationStatus.CLOSED;
        this.closedAt = LocalDateTime.now();
    }

    public void addMessage(Message message) {
        messages.add(message);
        message.setConversation(this);
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = ConversationStatus.ACTIVE;
    }
}
