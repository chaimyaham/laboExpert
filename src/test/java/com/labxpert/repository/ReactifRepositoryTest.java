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

import com.labxpert.model.Reactif;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReactifRepositoryTest {

    @Autowired
    private ReactifRepository reactifRepository;

    private Reactif savedReactif;

    @BeforeEach
    public void setUp() {
        Reactif reactif = new Reactif();
        reactif.setNom("ReactifExample");
        reactif.setDescription("DescriptionExample");
        reactif.setQuantiteStock(10);
        reactif.setDateExpiration(LocalDate.now().plusMonths(6));
        reactif.setFournisseur("FournisseurExample");

        savedReactif = reactifRepository.save(reactif);
    }

    @Test
    public void testSaveReactif() {
        assertNotNull(savedReactif.getId());
    }

    @Test
    public void testUpdateReactif() {
        savedReactif.setNom("NouveauNomReactif");
        savedReactif.setDescription("NouvelleDescriptionReactif");
        Reactif updatedReactif = reactifRepository.save(savedReactif);
        Optional<Reactif> retrievedReactif = reactifRepository.findById(updatedReactif.getId());

        assertTrue(retrievedReactif.isPresent());
        assertEquals(updatedReactif.getId(), retrievedReactif.get().getId());
        assertEquals("NouveauNomReactif", retrievedReactif.get().getNom());
        assertEquals("NouvelleDescriptionReactif", retrievedReactif.get().getDescription());
    }

    @Test
    public void testGetAllReactifs() {
        List<Reactif> allReactifs = reactifRepository.findAll();
        assertFalse(allReactifs.isEmpty());
    }

    @Test
    public void testGetReactifById() {
        Optional<Reactif> retrievedReactif = reactifRepository.findById(savedReactif.getId());
        assertTrue(retrievedReactif.isPresent());
        assertEquals(savedReactif.getId(), retrievedReactif.get().getId());
    }

    @Test
    public void testDeleteReactif() {
        reactifRepository.deleteById(savedReactif.getId());
        Optional<Reactif> retrievedReactif = reactifRepository.findById(savedReactif.getId());
        assertFalse(retrievedReactif.isPresent());
    }

    @AfterEach
    public void tearDown() {
        reactifRepository.deleteAll();
    }
}
