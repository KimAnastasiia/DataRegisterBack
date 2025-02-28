package com.uniovi.repositories;
import com.uniovi.entities.Movilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
public interface MovilidadRepository  extends JpaRepository<Movilidad, Long> {


    // Calculate indicator: SUM(plazasOfertadas) / SUM(plazasCubiertas) within date range
    @Query("SELECT SUM(m.plazasOfertadas) * 1.0 / SUM(m.plazasCubiertas) FROM Movilidad m WHERE m.fecha BETWEEN :startDate AND :endDate")
    Double getIndicador(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
