package com.adriank.Chatbot.repository;

import com.adriank.Chatbot.domain.Bot;
import com.adriank.Chatbot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BotRepository extends JpaRepository<Bot, Long> {

    List<Bot> findByOwner(User owner);

    List<Bot> findByOwnerId(Long ownerId);
}
