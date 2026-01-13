package com.adriank.Chatbot.repository;

import com.adriank.Chatbot.domain.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation,Long> {
}
