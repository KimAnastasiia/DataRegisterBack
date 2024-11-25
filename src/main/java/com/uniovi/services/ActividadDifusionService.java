package com.uniovi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.ActividadDifusion;
import com.uniovi.repositories.ActividadDifusionRepository;

import java.util.List;

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

    public ActividadDifusion saveActividad(ActividadDifusion actividad) {
        return repository.save(actividad);
    }

    public void deleteActividad(Long id) {
        repository.deleteById(id);
    }
}
