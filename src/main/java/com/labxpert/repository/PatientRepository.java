package com.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labxpert.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
