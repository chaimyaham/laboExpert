package com.labxpert.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.labxpert.model.enums.Role;
import com.labxpert.model.enums.StatutEchantillon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "echantillon")
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

    @ManyToOne
    @JoinColumn(name = "materiel_prelevement_id")
    private MaterielPrelevement materielPrelevement;

}
