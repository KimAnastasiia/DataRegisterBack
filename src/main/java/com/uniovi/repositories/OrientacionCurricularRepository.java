package com.uniovi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniovi.entities.OrientacionCurricular;

@Repository
public interface OrientacionCurricularRepository extends JpaRepository<OrientacionCurricular, Long> {
}