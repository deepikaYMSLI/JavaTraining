package com.ymsli.bank.inhouse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ymsli.bank.inhouse.dto.LoginRequest;
import com.ymsli.bank.inhouse.dto.LoginResponse;
import com.ymsli.bank.inhouse.model.User;
import com.ymsli.bank.inhouse.repository.UserRepository;
import com.ymsli.bank.inhouse.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {

        User user = userRepository.findByUsername(req.getUsername()).orElse(null);

        if (user == null || !user.getPassword().equals(req.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = JwtUtil.generateToken(user.getId(), user.getRole().name());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
