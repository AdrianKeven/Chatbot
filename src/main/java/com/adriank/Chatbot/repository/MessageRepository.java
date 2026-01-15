package com.adriank.Chatbot.repository;

import com.adriank.Chatbot.domain.Message;
import com.adriank.Chatbot.domain.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByConversation(Conversation conversation);

    List<Message> findByConversationIdOrderByIdAsc(Long conversationId);
}
