package com.smartclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartclinic.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>{
}
