package com.labxpert.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materiel_prelevement")
public class MaterielPrelevement extends BaseClass {
    @OneToMany(mappedBy = "materielPrelevement")
    private List<Echantillon> echantillons;
}