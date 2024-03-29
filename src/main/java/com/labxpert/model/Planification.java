package com.labxpert.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "\"planification\"")
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @OneToMany(mappedBy = "planification")
    private List<Analyse> analyse;

    @ManyToOne
    private Utilisateur technicienAssigné;

    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;
	
}
