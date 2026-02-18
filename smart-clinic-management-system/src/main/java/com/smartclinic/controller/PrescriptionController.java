package com.smartclinic.controller;

import com.smartclinic.entity.Prescription;
import com.smartclinic.service.TokenService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final TokenService tokenService;

    public PrescriptionController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/{token}")
    public ResponseEntity<?> createPrescription(
            @PathVariable String token,
            @Valid @RequestBody Prescription prescription) {

        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(Map.of("error", "Invalid token"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Prescription created successfully")
        );
    }
}
