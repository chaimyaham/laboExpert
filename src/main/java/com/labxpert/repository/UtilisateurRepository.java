package com.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labxpert.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

}
