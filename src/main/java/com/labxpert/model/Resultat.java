package com.labxpert.model;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.labxpert.model.enums.StatutResultat;

@Entity
public class Resultat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    private Analyse analyse;
	
    private String valeursResultats;
    private String unitesMesure;

    @Enumerated(EnumType.STRING)
    private StatutResultat statut;

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

	public String getValeursResultats() {
		return valeursResultats;
	}

	public void setValeursResultats(String valeursResultats) {
		this.valeursResultats = valeursResultats;
	}

	public String getUnitesMesure() {
		return unitesMesure;
	}

	public void setUnitesMesure(String unitesMesure) {
		this.unitesMesure = unitesMesure;
	}

	public StatutResultat getStatut() {
		return statut;
	}

	public void setStatut(StatutResultat statut) {
		this.statut = statut;
	}
    
    

	
	
}
