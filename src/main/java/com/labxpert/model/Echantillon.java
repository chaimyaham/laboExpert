package com.labxpert.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.labxpert.model.enums.StatutEchantillon;

@Entity
public class Echantillon {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @ManyToOne
    private Patient patient;
	
	
	private String type_analyse;
	private LocalDateTime date_de_prelevement;
	
    @Enumerated(EnumType.STRING)
    private StatutEchantillon statut;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getType_analyse() {
		return type_analyse;
	}

	public void setType_analyse(String type_analyse) {
		this.type_analyse = type_analyse;
	}

	public LocalDateTime getDate_de_prelevement() {
		return date_de_prelevement;
	}

	public void setDate_de_prelevement(LocalDateTime date_de_prelevement) {
		this.date_de_prelevement = date_de_prelevement;
	}

	public StatutEchantillon getStatut() {
		return statut;
	}

	public void setStatut(StatutEchantillon statut) {
		this.statut = statut;
	}
	
	
	
	

}
