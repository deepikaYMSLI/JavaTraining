package com.smartclinic.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="appointment")
public class Appointment {

 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 @JoinColumn(name="doctor_id")
 private Doctor doctor;

 @ManyToOne
 @JoinColumn(name="patient_id")
 private Patient patient;

 private LocalDateTime appointmentTime;

 private String status;

 public Appointment(){}

 public Long getId(){ return id; }

 public Doctor getDoctor(){ return doctor; }
 public void setDoctor(Doctor doctor){ this.doctor=doctor; }

 public Patient getPatient(){ return patient; }
 public void setPatient(Patient patient){ this.patient=patient; }

 public LocalDateTime getAppointmentTime(){ return appointmentTime; }
 public void setAppointmentTime(LocalDateTime appointmentTime){
  this.appointmentTime=appointmentTime;
 }

}
