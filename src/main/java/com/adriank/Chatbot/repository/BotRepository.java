package com.adriank.Chatbot.repository;

import com.adriank.Chatbot.domain.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotRepository extends JpaRepository<Bot,Long> {
}
