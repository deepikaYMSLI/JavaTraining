package com.smartclinic.controller;

import com.smartclinic.service.DoctorService;
import com.smartclinic.service.TokenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final TokenService tokenService;

    public DoctorController(DoctorService doctorService, TokenService tokenService) {
        this.doctorService = doctorService;
        this.tokenService = tokenService;
    }

    // REQUIRED FORMAT
    @GetMapping("/availability/{doctorId}/{token}")
    public ResponseEntity<?> getAvailability(
            @PathVariable Long doctorId,
            @PathVariable String token) {

        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(401)
                    .body(Map.of("error", "Invalid token"));
        }

        return ResponseEntity.ok(
                doctorService.getDoctorAvailability(doctorId)
        );
    }
}
