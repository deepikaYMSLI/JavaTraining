package com.smartclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartclinic.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{
}
