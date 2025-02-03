package com.uniovi.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniovi.entities.JornadaAcogida;

public interface JornadaAcogidaRepository extends JpaRepository<JornadaAcogida, Long> {
	List<JornadaAcogida> findByFechaBetween(LocalDate startDate, LocalDate endDate);
}