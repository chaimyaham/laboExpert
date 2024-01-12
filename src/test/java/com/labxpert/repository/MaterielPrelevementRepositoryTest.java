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

import com.labxpert.model.MaterielPrelevement;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MaterielPrelevementRepositoryTest {

    @Autowired
    private MaterielPrelevementRepository materielPrelevementRepository;

    private MaterielPrelevement savedMaterielPrelevement;

    @BeforeEach
    public void setUp() {
        MaterielPrelevement materielPrelevement = new MaterielPrelevement();
        materielPrelevement.setNom("MaterielPrelevementExample");
        materielPrelevement.setDescription("DescriptionExample");
        materielPrelevement.setQuantiteStock(10);
        materielPrelevement.setDateExpiration(LocalDate.now().plusMonths(6));  
        materielPrelevement.setFournisseur("FournisseurExample");

        savedMaterielPrelevement = materielPrelevementRepository.save(materielPrelevement);
    }

    @Test
    public void testSaveMaterielPrelevement() {
        assertNotNull(savedMaterielPrelevement.getId());
    }

    @Test
    public void testUpdateMaterielPrelevement() {
        savedMaterielPrelevement.setNom("NouveauNomMaterielPrelevement");
        savedMaterielPrelevement.setDescription("NouvelleDescriptionMaterielPrelevement");
        MaterielPrelevement updatedMaterielPrelevement = materielPrelevementRepository.save(savedMaterielPrelevement);
        Optional<MaterielPrelevement> retrievedMaterielPrelevement = materielPrelevementRepository.findById(updatedMaterielPrelevement.getId());

        assertTrue(retrievedMaterielPrelevement.isPresent());
        assertEquals(updatedMaterielPrelevement.getId(), retrievedMaterielPrelevement.get().getId());
        assertEquals("NouveauNomMaterielPrelevement", retrievedMaterielPrelevement.get().getNom());
        assertEquals("NouvelleDescriptionMaterielPrelevement", retrievedMaterielPrelevement.get().getDescription());
    }

    @Test
    public void testGetAllMaterielPrelevements() {
        List<MaterielPrelevement> allMaterielPrelevements = materielPrelevementRepository.findAll();
        assertFalse(allMaterielPrelevements.isEmpty());
    }

    @Test
    public void testGetMaterielPrelevementById() {
        Optional<MaterielPrelevement> retrievedMaterielPrelevement = materielPrelevementRepository.findById(savedMaterielPrelevement.getId());
        assertTrue(retrievedMaterielPrelevement.isPresent());
        assertEquals(savedMaterielPrelevement.getId(), retrievedMaterielPrelevement.get().getId());
    }

    @Test
    public void testDeleteMaterielPrelevement() {
        materielPrelevementRepository.deleteById(savedMaterielPrelevement.getId());
        Optional<MaterielPrelevement> retrievedMaterielPrelevement = materielPrelevementRepository.findById(savedMaterielPrelevement.getId());
        assertFalse(retrievedMaterielPrelevement.isPresent());
    }

    @AfterEach
    public void tearDown() {
        materielPrelevementRepository.deleteAll();
    }
}
