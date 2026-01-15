package com.adriank.Chatbot.service;

import com.adriank.Chatbot.Mapper.UserMapper;
import com.adriank.Chatbot.domain.User;
import com.adriank.Chatbot.dto.CreateDTO.UserCreateDTO;
import com.adriank.Chatbot.dto.DefaultDTO.UserDTO;
import com.adriank.Chatbot.dto.Summary.UserSummaryDTO;
import com.adriank.Chatbot.dto.Update.UserUpdateDTO;
import com.adriank.Chatbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO create(UserCreateDTO dto) {
        User user = UserMapper.toEntity(dto);
        return UserMapper.toDTO(userRepository.save(user));
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<UserSummaryDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    public UserDTO update(Long id, UserUpdateDTO dto) {
        User user = findById(id);
        UserMapper.updateEntity(user, dto);
        return UserMapper.toDTO(userRepository.save(user));
    }

    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
