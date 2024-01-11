package com.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labxpert.model.Planification;

public interface PlanificationRepository extends JpaRepository<Planification,Long> {

}
