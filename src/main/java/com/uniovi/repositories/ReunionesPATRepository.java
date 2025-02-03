package com.uniovi.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniovi.entities.ReunionesPAT;

public interface ReunionesPATRepository extends JpaRepository<ReunionesPAT, Long> {
	@Query("SELECT SUM(r.numeroReuniones) FROM ReunionesPAT r WHERE r.fecha BETWEEN :startDate AND :endDate")
    Integer getSumReuniones(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
