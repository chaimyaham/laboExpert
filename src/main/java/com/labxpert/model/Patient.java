package com.labxpert.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.labxpert.model.enums.Sexe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String prenom;
	private LocalDate date_de_naissance;
	
	@Enumerated(EnumType.STRING)
    private Sexe sexe;

	private String address;
	private String numero_de_telephone;
	


	@OneToMany(mappedBy = "patient")  
	private List<Analyse> analysisHistory;


	

}
