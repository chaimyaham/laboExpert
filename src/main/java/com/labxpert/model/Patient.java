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

import com.labxpert.model.enums.Sexe;

@Entity
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public LocalDate getDate_de_naissance() {
		return date_de_naissance;
	}


	public void setDate_de_naissance(LocalDate date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}


	public Sexe getSexe() {
		return sexe;
	}


	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getNumero_de_telephone() {
		return numero_de_telephone;
	}


	public void setNumero_de_telephone(String numero_de_telephone) {
		this.numero_de_telephone = numero_de_telephone;
	}


	public List<Analyse> getAnalysisHistory() {
		return analysisHistory;
	}


	public void setAnalysisHistory(List<Analyse> analysisHistory) {
		this.analysisHistory = analysisHistory;
	}

	
	

}
