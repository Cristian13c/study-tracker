package com.studytracker.controller;

import com.studytracker.model.User;
import com.studytracker.service.UserService;
import com.studytracker.security.JwtUtil;
import com.studytracker.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        userService.login(request.getEmail(), request.getPassword());

        return jwtUtil.generateToken(request.getEmail());
    }
}