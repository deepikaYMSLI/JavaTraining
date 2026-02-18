package com.smartclinic.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    // Validate token
    public boolean validateToken(String token) {

        if(token == null || token.isEmpty()) {
            return false;
        }

        // Simple validation for assignment
        if(token.equals("Bearer valid-token")) {
            return true;
        }

        return false;
    }

}
