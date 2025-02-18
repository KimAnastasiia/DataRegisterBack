package com.uniovi.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uniovi.entities.OrientacionCurricular;

@Repository
public interface OrientacionCurricularRepository extends JpaRepository<OrientacionCurricular, Long> {
	  @Query("SELECT SUM(o.numParticipantes) FROM OrientacionCurricular o WHERE o.fecha BETWEEN :startDate AND :endDate")
	    Integer sumParticipantesByFecha(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}