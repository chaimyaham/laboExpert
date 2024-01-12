package com.labxpert.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.labxpert.model.Echantillon;
import com.labxpert.model.MaterielPrelevement;
import com.labxpert.model.Patient;
import com.labxpert.model.enums.Sexe;
import com.labxpert.model.enums.StatutEchantillon;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EchantillonRepositoryTest {

    @Autowired
    private EchantillonRepository echantillonRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MaterielPrelevementRepository materielPrelevementRepository;

    private Echantillon savedEchantillon;

    @BeforeEach
    public void setUp() {
                Patient patient = Patient.builder()
                .nom("NomPatientExample")
                .prenom("PrenomPatientExample")
                .date_de_naissance(LocalDate.of(1990, 1, 1))
                .sexe(Sexe.HOMME)
                .address("AdressePatientExample")
                .numero_de_telephone("0123456789")
                .build();
        patientRepository.save(patient);

        MaterielPrelevement materielPrelevement = new MaterielPrelevement();
        materielPrelevement.setNom("MaterielPrelevementExample");
        materielPrelevement.setDescription("DescriptionExample");
        materielPrelevement.setQuantiteStock(10);
        materielPrelevement.setDateExpiration(LocalDate.now().plusMonths(6)); 
        materielPrelevement.setFournisseur("FournisseurExample");
        materielPrelevementRepository.save(materielPrelevement);

        Echantillon echantillon = Echantillon.builder()
                .patient(patient)
                .type_analyse("TypeAnalyseExample")
                .date_de_prelevement(LocalDateTime.now())
                .statut(StatutEchantillon.EN_ATTENTE)
                .materielPrelevement(materielPrelevement)
                .build();
        
        savedEchantillon = echantillonRepository.save(echantillon);
    }

    @Test
    public void testSaveEchantillon() {
        assertNotNull(savedEchantillon.getId());
    }

    @Test
    public void testUpdateEchantillon() {
        savedEchantillon = Echantillon.builder()
                .id(savedEchantillon.getId())
                .patient(savedEchantillon.getPatient())
                .type_analyse("NouveauTypeAnalyse")
                .date_de_prelevement(savedEchantillon.getDate_de_prelevement())
                .statut(StatutEchantillon.EN_COURS_D_ANALYSE)
                .materielPrelevement(savedEchantillon.getMaterielPrelevement())
                .build();

        Echantillon updatedEchantillon = echantillonRepository.save(savedEchantillon);
        Optional<Echantillon> retrievedEchantillon = echantillonRepository.findById(updatedEchantillon.getId());

        assertTrue(retrievedEchantillon.isPresent());
        assertEquals(updatedEchantillon.getId(), retrievedEchantillon.get().getId());
        assertEquals("NouveauTypeAnalyse", retrievedEchantillon.get().getType_analyse());
        assertEquals(StatutEchantillon.EN_COURS_D_ANALYSE, retrievedEchantillon.get().getStatut());
    }

    @Test
    public void testGetAllEchantillons() {
        List<Echantillon> allEchantillons = echantillonRepository.findAll();
        assertFalse(allEchantillons.isEmpty());
    }

    @Test
    public void testGetEchantillonById() {
        Optional<Echantillon> retrievedEchantillon = echantillonRepository.findById(savedEchantillon.getId());
        assertTrue(retrievedEchantillon.isPresent());
        assertEquals(savedEchantillon.getId(), retrievedEchantillon.get().getId());
    }

    @Test
    public void testDeleteEchantillon() {
        echantillonRepository.deleteById(savedEchantillon.getId());
        Optional<Echantillon> retrievedEchantillon = echantillonRepository.findById(savedEchantillon.getId());
        assertFalse(retrievedEchantillon.isPresent());
    }

    @AfterEach
    public void tearDown() {
        echantillonRepository.deleteAll();
        patientRepository.deleteAll();
        materielPrelevementRepository.deleteAll();
    }
}

