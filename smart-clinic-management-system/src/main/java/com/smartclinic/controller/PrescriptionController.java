package com.smartclinic.controller;

import com.smartclinic.entity.Prescription;
import com.smartclinic.repository.PrescriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Create prescription
    @PostMapping
    public ResponseEntity<?> createPrescription(
            @RequestBody Prescription prescription) {

        Prescription saved =
                prescriptionRepository.save(prescription);

        return ResponseEntity.ok(saved);
    }

    // Get all prescriptions
    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {

        return ResponseEntity.ok(
                prescriptionRepository.findAll()
        );
    }

}
