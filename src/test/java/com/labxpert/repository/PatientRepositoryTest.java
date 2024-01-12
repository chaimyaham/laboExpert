package com.labxpert.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.labxpert.model.Patient;
import com.labxpert.model.enums.Sexe;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    private Patient savedPatient;

    @BeforeEach
    public void setUp() {
        Patient patient = Patient.builder()
                .nom("NomExample")
                .prenom("PrenomExample")
                .date_de_naissance(LocalDate.of(1990, 1, 1))
                .sexe(Sexe.HOMME)
                .address("AdresseExample")
                .numero_de_telephone("0123456789")
                .build();
        savedPatient = patientRepository.save(patient);
    }

    @Test
    public void testSavePatient() {
        assertNotNull(savedPatient.getId());
    }

    @Test
    public void testUpdatePatient() {
        savedPatient.setNom("NouveauNom");
        savedPatient.setAddress("NouvelleAdresse");
        Patient updatedPatient = patientRepository.save(savedPatient);
        Optional<Patient> retrievedPatient = patientRepository.findById(updatedPatient.getId());

        assertTrue(retrievedPatient.isPresent());
        assertEquals(updatedPatient.getId(), retrievedPatient.get().getId());
        assertEquals("NouveauNom", retrievedPatient.get().getNom());
        assertEquals("NouvelleAdresse", retrievedPatient.get().getAddress());
    }

    @Test
    public void testGetAllPatients() {
        List<Patient> allPatients = patientRepository.findAll();
        assertFalse(allPatients.isEmpty());
    }

    @Test
    public void testGetPatientById() {
        Optional<Patient> retrievedPatient = patientRepository.findById(savedPatient.getId());
        assertTrue(retrievedPatient.isPresent());
        assertEquals(savedPatient.getId(), retrievedPatient.get().getId());
    }

    @Test
    public void testDeletePatient() {
        patientRepository.deleteById(savedPatient.getId());
        Optional<Patient> retrievedPatient = patientRepository.findById(savedPatient.getId());
        assertFalse(retrievedPatient.isPresent());
    }

    @AfterEach
    public void tearDown() {
    
        patientRepository.deleteAll();
    }
}
