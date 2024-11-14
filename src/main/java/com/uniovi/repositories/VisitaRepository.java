package com.uniovi.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniovi.entities.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {
    // You can add custom queries here if needed (e.g., find by colegio)
	List<Visita> findByFechaBetween(LocalDate startDate, LocalDate endDate);
}