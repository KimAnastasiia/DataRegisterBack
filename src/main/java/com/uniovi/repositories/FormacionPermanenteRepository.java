package com.uniovi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniovi.entities.FormacionPermanente;

import java.time.LocalDate;
import java.util.List;
public interface FormacionPermanenteRepository extends JpaRepository<FormacionPermanente, Long> {

    @Query("SELECT AVG(f.porcentajeParticipacion) FROM FormacionPermanente f WHERE f.fecha BETWEEN :startDate AND :endDate")
    Double calcularMediaPorcentaje(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

  
}
