package com.smartclinic.service;

import com.smartclinic.entity.Doctor;
import com.smartclinic.repository.DoctorRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<String> getDoctorAvailability(Long doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        return doctor.getAvailableTimes();
    }

    public Doctor validateLogin(String email, String password) {

        Doctor doctor = doctorRepository.findByEmail(email).orElse(null);

        if (doctor != null && doctor.getPassword().equals(password)) {
            return doctor;
        }

        return null;
    }
}
