package com.uniovi.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.ActividadDifusion;
import com.uniovi.repositories.ActividadDifusionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
@Service
public class ActividadDifusionService {

    private final ActividadDifusionRepository repository;

    @Autowired
    public ActividadDifusionService(ActividadDifusionRepository repository) {
        this.repository = repository;
    }

    public List<ActividadDifusion> getAllActividades() {
        return repository.findAll();
    }

    public ActividadDifusion getActividadById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }
    public Page<ActividadDifusion> getActividadesBetweenDates(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return repository.findByFechaBetween(startDate, endDate, pageable);
    }
    public Map<String, Long> getStatisticsBetweenDates(LocalDate startDate, LocalDate endDate) {
        Map<String, Long> statistics = new HashMap<>();
        statistics.put("totalActividades", repository.countByFechaBetween(startDate, endDate));
        statistics.put("totalParticipantes", repository.sumParticipantesByFechaBetween(startDate, endDate));
        return statistics;
    }
    public ActividadDifusion saveActividad(ActividadDifusion actividad) {
        return repository.save(actividad);
    }

    public void deleteActividad(Long id) {
        repository.deleteById(id);
    }
}
