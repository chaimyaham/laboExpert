package com.labxpert.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.labxpert.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "reactif")
@Builder 
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Reactif extends BaseClass {
	
    @OneToMany(mappedBy = "reactif")
    private List<AnalyseReactif> analyseReactifs;
}