package com.adriank.Chatbot.repository;

import com.adriank.Chatbot.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
