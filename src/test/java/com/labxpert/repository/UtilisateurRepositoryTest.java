package com.labxpert.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.labxpert.model.Utilisateur;
import com.labxpert.model.enums.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UtilisateurRepositoryTest {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private Utilisateur savedUtilisateur;

    @BeforeEach
    public void setUp() {
        Utilisateur utilisateur = Utilisateur.builder()
                .nomUtilisateur("NomUtilisateurExample")
                .motDePasse("MotDePasseExample")
                .role(Role.TECHNICIEN)
                .nom_et_prenom("NomPrenomExample")
                .email("example@example.com")
                .build();
        savedUtilisateur = utilisateurRepository.save(utilisateur);
    }

    @Test
    public void testSaveUtilisateur() {
        assertNotNull(savedUtilisateur.getId());
    }

    @Test
    public void testUpdateUtilisateur() {
        savedUtilisateur.setNom_et_prenom("NouveauNomPrenom");
        savedUtilisateur.setEmail("nouveau@example.com");
        Utilisateur updatedUtilisateur = utilisateurRepository.save(savedUtilisateur);
        Optional<Utilisateur> retrievedUtilisateur = utilisateurRepository.findById(updatedUtilisateur.getId());

        assertTrue(retrievedUtilisateur.isPresent());
        assertEquals(updatedUtilisateur.getId(), retrievedUtilisateur.get().getId());
        assertEquals("NouveauNomPrenom", retrievedUtilisateur.get().getNom_et_prenom());
        assertEquals("nouveau@example.com", retrievedUtilisateur.get().getEmail());
    }

    @Test
    public void testGetAllUtilisateurs() {
        List<Utilisateur> allUtilisateurs = utilisateurRepository.findAll();
        assertFalse(allUtilisateurs.isEmpty());
    }

    @Test
    public void testGetUtilisateurById() {
        Optional<Utilisateur> retrievedUtilisateur = utilisateurRepository.findById(savedUtilisateur.getId());
        assertTrue(retrievedUtilisateur.isPresent());
        assertEquals(savedUtilisateur.getId(), retrievedUtilisateur.get().getId());
    }

    @Test
    public void testDeleteUtilisateur() {
        utilisateurRepository.deleteById(savedUtilisateur.getId());
        Optional<Utilisateur> retrievedUtilisateur = utilisateurRepository.findById(savedUtilisateur.getId());
        assertFalse(retrievedUtilisateur.isPresent());
    }

    @AfterEach
    public void tearDown() {
        utilisateurRepository.deleteAll();
    }
}
