package com.labxpert.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class EchantillonTestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "echantillon_id")
    private Echantillon echantillon;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "analyse_id")
    private Analyse analyse;

    private Double result_value;


}
