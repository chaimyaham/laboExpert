package com.labxpert.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.labxpert.model.enums.Role;

import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomUtilisateur;

    private String motDePasse; 

    @Enumerated(EnumType.STRING)
    private Role role;
    
    private String nom_et_prenom;
    private String email;
		

}
