package com.studytracker.service;

import com.studytracker.model.User;
import com.studytracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(User user) {

        // Validar si ya existe
        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("El usuario ya existe");
                });

        // Encriptar password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return user;
    }
}