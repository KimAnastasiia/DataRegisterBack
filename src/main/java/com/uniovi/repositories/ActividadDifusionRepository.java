package com.uniovi.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniovi.entities.ActividadDifusion;
import java.time.LocalDate;
public interface ActividadDifusionRepository extends JpaRepository<ActividadDifusion, Long> {
	 Page<ActividadDifusion> findByFechaBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
	 
	 @Query("SELECT COUNT(a) FROM ActividadDifusion a WHERE a.fecha BETWEEN :startDate AND :endDate")
	 long countByFechaBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

	  @Query("SELECT SUM(a.participantes) FROM ActividadDifusion a WHERE a.fecha BETWEEN :startDate AND :endDate")
	  long sumParticipantesByFechaBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}