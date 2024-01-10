package com.labxpert.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Analyse analyse;

    @ManyToOne
    private Utilisateur technicienAssigné;

    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Analyse getAnalyse() {
		return analyse;
	}
	public void setAnalyse(Analyse analyse) {
		this.analyse = analyse;
	}
	public Utilisateur getTechnicienAssigné() {
		return technicienAssigné;
	}
	public void setTechnicienAssigné(Utilisateur technicienAssigné) {
		this.technicienAssigné = technicienAssigné;
	}
	public LocalDateTime getDateHeureDebut() {
		return dateHeureDebut;
	}
	public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}
	public LocalDateTime getDateHeureFin() {
		return dateHeureFin;
	}
	public void setDateHeureFin(LocalDateTime dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}

  
}
