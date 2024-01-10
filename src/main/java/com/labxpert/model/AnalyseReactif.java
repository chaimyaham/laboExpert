package com.labxpert.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnalyseReactif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Analyse analyse;

    @ManyToOne
    private Reactif reactif;

    private int quantiteUtilisee;

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

	public Reactif getReactif() {
		return reactif;
	}

	public void setReactif(Reactif reactif) {
		this.reactif = reactif;
	}

	public int getQuantiteUtilisee() {
		return quantiteUtilisee;
	}

	public void setQuantiteUtilisee(int quantiteUtilisee) {
		this.quantiteUtilisee = quantiteUtilisee;
	}

}
