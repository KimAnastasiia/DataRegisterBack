package com.uniovi.repositories;


import com.uniovi.entities.InnovacionDocente;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InnovacionDocenteRepository extends JpaRepository<InnovacionDocente, Long> {
	
	  @Query("SELECT AVG(i.porcentajeProfesoresParticipantes) FROM InnovacionDocente i WHERE i.fecha BETWEEN :startDate AND :endDate")
    Double findAverageParticipation(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
