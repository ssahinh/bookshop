package com.bookshop.bookshop.services;

import com.bookshop.bookshop.dtos.user.CreateUserDto;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CreateUserDto createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);

        return CreateUserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public CreateUserDto getUser(String username) {
        User savedUser = null;
        try {
            savedUser = findByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return CreateUserDto.builder()
                .password(savedUser.getPassword())
                .email(savedUser.getEmail())
                .build();
    }

    public User findByUsername(String username) throws Exception {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new Exception("HATA"));
    }
}
