package com.labxpert.model;

import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "\"test\"")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_du_test;
    private Double valeur_min;
    private Double valeur_max;
    private String unite_de_mesure;

}

