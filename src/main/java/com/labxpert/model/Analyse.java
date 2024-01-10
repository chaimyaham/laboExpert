package com.labxpert.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Analyse {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Echantillon echantillon;
	
    @ManyToOne
    private Utilisateur technicienResponsable;
    
	private Date date_debut_analyse;
	private Date date_fin_analyse;

//je vais faire cette relation ici one to many parcequ'une analyse peut avoir plusieur resulltat
    @OneToMany(mappedBy = "analyse")
    private List<Resultat> resultats;
	private String Commentaire;
	
    @OneToMany(mappedBy = "analyse")
    private List<AnalyseReactif> analyseReactifs;
    
  
    @ManyToOne
    @JoinColumn(name = "patient_id")  
    private Patient patient;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Echantillon getEchantillon() {
		return echantillon;
	}
	public void setEchantillon(Echantillon echantillon) {
		this.echantillon = echantillon;
	}
	public Utilisateur getTechnicienResponsable() {
		return technicienResponsable;
	}
	public void setTechnicienResponsable(Utilisateur technicienResponsable) {
		this.technicienResponsable = technicienResponsable;
	}
	public Date getDate_debut_analyse() {
		return date_debut_analyse;
	}
	public void setDate_debut_analyse(Date date_debut_analyse) {
		this.date_debut_analyse = date_debut_analyse;
	}
	public Date getDate_fin_analyse() {
		return date_fin_analyse;
	}
	public void setDate_fin_analyse(Date date_fin_analyse) {
		this.date_fin_analyse = date_fin_analyse;
	}
	public List<Resultat> getResultats() {
		return resultats;
	}
	public void setResultats(List<Resultat> resultats) {
		this.resultats = resultats;
	}
	public String getCommentaire() {
		return Commentaire;
	}
	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}
	

}
