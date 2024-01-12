package com.labxpert;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.labxpert.model.Patient;
import com.labxpert.model.enums.Sexe;
import com.labxpert.repository.PatientRepository;

@SpringBootApplication
public class LaboManagementSystemApplication implements CommandLineRunner  {
	
	 @Autowired
	    private PatientRepository patientRepository;


	public static void main(String[] args) {
		SpringApplication.run(LaboManagementSystemApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		  Patient patient = Patient.builder()
	                .nom("NomExample")
	                .prenom("PrenomExample")
	                .date_de_naissance(LocalDate.of(1990, 1, 1))
	                .sexe(Sexe.HOMME)
	                .address("AdresseExample")
	                .numero_de_telephone("0123456789")
	                .build();
		  
        patientRepository.save(patient);
        System.out.println(patient.toString());

        List<Patient> allPatients = patientRepository.findAll();
        System.out.println("All patients:");
        for (Patient p : allPatients) {
            System.out.println(patient);
        }

        System.out.println("All patients after saving:");
        allPatients = patientRepository.findAll();
        for (Patient p : allPatients) {
            System.out.println(p);
        }
    }
		
	}


