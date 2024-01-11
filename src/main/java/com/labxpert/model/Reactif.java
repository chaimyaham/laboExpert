package com.labxpert.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "reactif")
public class Reactif extends BaseClass {
	
    @OneToMany(mappedBy = "reactif")
    private List<AnalyseReactif> analyseReactifs;
}