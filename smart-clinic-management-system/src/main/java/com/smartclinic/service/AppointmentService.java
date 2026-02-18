package com.smartclinic.service;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

 public String bookAppointment(Long doctorId,Long patientId){

  if(doctorId==null)
   throw new RuntimeException("Doctor not found");

  if(patientId==null)
   throw new RuntimeException("Patient not found");

  return "Appointment booked successfully";
 }

}
