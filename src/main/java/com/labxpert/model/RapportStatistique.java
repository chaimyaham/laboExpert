package com.labxpert.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RapportStatistique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeRapport;

    private String periodeRapport;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeRapport() {
		return typeRapport;
	}

	public void setTypeRapport(String typeRapport) {
		this.typeRapport = typeRapport;
	}

	public String getPeriodeRapport() {
		return periodeRapport;
	}

	public void setPeriodeRapport(String periodeRapport) {
		this.periodeRapport = periodeRapport;
	}

  
}
