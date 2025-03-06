package com.uniovi.repositories;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniovi.entities.Bilingue;

public interface BilingueRepository extends JpaRepository<Bilingue, Long> {
    List<Bilingue> findByFechaBetween(LocalDate startDate, LocalDate endDate);
}