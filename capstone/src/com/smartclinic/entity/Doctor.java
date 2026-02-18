package com.smartclinic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Doctor name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Invalid email format")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Phone is required")
    @Size(min = 10, max = 15)
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "Specialization is required")
    @Column(nullable = false)
    private String specialization;

    // REQUIRED FIELD AS PER QUESTION
    @Column(name = "available_times")
    private String availableTimes;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;

    // Default constructor
    public Doctor() {
    }

    // Parameterized constructor
    public Doctor(String name, String email, String phone, String specialization, String availableTimes, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.specialization = specialization;
        this.availableTimes = availableTimes;
        this.password = password;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(String availableTimes) {
        this.availableTimes = availableTimes;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
