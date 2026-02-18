package com.smartclinic.controller;

import com.smartclinic.entity.Doctor;
import com.smartclinic.service.DoctorService;
import com.smartclinic.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TokenService tokenService;

    // REQUIRED GET ENDPOINT WITH DYNAMIC PARAMETERS
    @GetMapping("/availability")
    public ResponseEntity<?> getDoctorAvailability(
            @RequestHeader("Authorization") String token,
            @RequestParam String specialization,
            @RequestParam String date
    ) {

        Map<String, Object> response = new HashMap<>();

        // Validate token
        if (!tokenService.validateToken(token)) {
            response.put("status", "error");
            response.put("message", "Invalid or missing token");

            return ResponseEntity
                    .status(401)
                    .body(response);
        }

        try {

            LocalDate localDate = LocalDate.parse(date);

            List<Doctor> doctors =
                    doctorService.getAvailableDoctors(specialization, localDate);

            response.put("status", "success");
            response.put("count", doctors.size());
            response.put("data", doctors);

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            response.put("status", "error");
            response.put("message", e.getMessage());

            return ResponseEntity
                    .badRequest()
                    .body(response);
        }
    }

}
