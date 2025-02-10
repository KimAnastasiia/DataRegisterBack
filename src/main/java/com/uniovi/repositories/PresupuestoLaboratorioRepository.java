package com.uniovi.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uniovi.entities.PresupuestoLaboratorio;

@Repository
public interface PresupuestoLaboratorioRepository extends JpaRepository<PresupuestoLaboratorio, Long> {
	
	    @Query("SELECT SUM(p.presupuestoTotal) FROM PresupuestoLaboratorio p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin")
	    Double sumarPresupuestoTotalEntreFechas(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

	    @Query("SELECT SUM(p.presupuestoLaboratorios) FROM PresupuestoLaboratorio p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin")
	    Double sumarPresupuestoLaboratoriosEntreFechas(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
}