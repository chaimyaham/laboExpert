package com.labxpert.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.labxpert.model.enums.StatutResultat;

import lombok.Data;

@Data
@Entity
@Table(name = "\"analyse\"")
public class Analyse {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Echantillon echantillon;
	
    @ManyToOne
    private Utilisateur technicienResponsable;

	private LocalDateTime date_debut_analyse;
	private LocalDateTime date_fin_analyse;

	@ManyToOne
	@JoinColumn(name = "planification_id")
	private Planification planification;
	
    @ManyToOne
	@JoinColumn(name = "patient_id")  
	private Patient patient;
    
	private String Commentaire;
	
    @OneToMany(mappedBy = "analyse")
    private List<AnalyseReactif> analyseReactifs;
	
    @OneToMany(mappedBy = "analyse")
    private List<EchantillonTestResult> testsResults;
    
    @Enumerated(EnumType.STRING)
    private StatutResultat statutResultat;
	

}
