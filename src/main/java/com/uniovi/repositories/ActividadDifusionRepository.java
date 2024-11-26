package com.uniovi.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uniovi.entities.ActividadDifusion;
import java.time.LocalDate;
public interface ActividadDifusionRepository extends JpaRepository<ActividadDifusion, Long> {
	 Page<ActividadDifusion> findByFechaBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
}