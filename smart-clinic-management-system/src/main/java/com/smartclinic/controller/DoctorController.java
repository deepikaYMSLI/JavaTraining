package com.smartclinic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

 @GetMapping("/availability")
 public ResponseEntity<?> getAvailability(
  @RequestHeader("Authorization") String token,
  @RequestParam String specialization,
  @RequestParam String date){

  Map<String,String> response=new HashMap<>();
  response.put("status","success");
  response.put("specialization",specialization);
  response.put("date",date);

  return ResponseEntity.ok(response);
 }

}
