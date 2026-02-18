package com.smartclinic.service;

import com.smartclinic.entity.Doctor;
import com.smartclinic.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Save doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Get available doctors by specialization
    public List<Doctor> getAvailableDoctors(String specialization, LocalDate date) {

        // simple logic for assignment
        return doctorRepository.findAll()
                .stream()
                .filter(d -> d.getSpecialization()
                .equalsIgnoreCase(specialization))
                .toList();
    }

    // Delete doctor
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
