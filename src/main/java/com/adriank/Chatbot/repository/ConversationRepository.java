package com.adriank.Chatbot.repository;

import com.adriank.Chatbot.domain.Conversation;
import com.adriank.Chatbot.domain.Bot;
import com.adriank.Chatbot.domain.ConversationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findByPhoneNumberAndBot(String phoneNumber, Bot bot);

    Optional<Conversation> findByPhoneAndStatus(String phone, ConversationStatus status);

    List<Conversation> findByBotId(Long botId);

    List<Conversation> findByActiveTrue();

    List<Conversation> findByBot(Bot bot);
}
