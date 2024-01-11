package com.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labxpert.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}