package com.smartclinic.entity;



import jakarta.persistence.*;

@Entity
@Table(name="doctor")
public class Doctor {

 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;

 private String name;
 private String email;
 private String phone;
 private String specialization;

 @Column(name="available_times")
 private String availableTimes;

 private String password;

 public Doctor() {}

 public Long getId(){ return id; }

 public String getName(){ return name; }
 public void setName(String name){ this.name=name; }

 public String getEmail(){ return email; }
 public void setEmail(String email){ this.email=email; }

 public String getPhone(){ return phone; }
 public void setPhone(String phone){ this.phone=phone; }

 public String getSpecialization(){ return specialization; }
 public void setSpecialization(String specialization){ this.specialization=specialization; }

 public String getAvailableTimes(){ return availableTimes; }
 public void setAvailableTimes(String availableTimes){ this.availableTimes=availableTimes; }

 public String getPassword(){ return password; }
 public void setPassword(String password){ this.password=password; }

}
