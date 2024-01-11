package com.labxpert.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.labxpert.model.Analyse;

public interface AnalyseRepository extends JpaRepository<Analyse, Long> {
  
}