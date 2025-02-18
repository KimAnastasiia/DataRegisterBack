package com.uniovi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.OrientacionCurricular;
import com.uniovi.repositories.OrientacionCurricularRepository;

@Service
public class OrientacionCurricularService {

    @Autowired
    private OrientacionCurricularRepository repository;

    public List<OrientacionCurricular> getAll() {
        return repository.findAll();
    }

    public Optional<OrientacionCurricular> getById(Long id) {
        return repository.findById(id);
    }
    public double calcularIndicador(LocalDate startDate, LocalDate endDate) {
        Integer totalParticipantes = repository.sumParticipantesByFecha(startDate, endDate);
        if (totalParticipantes == null) {
            totalParticipantes = 0; // Si no hay registros, evitar null
        }
        return totalParticipantes / 150.0; // División entre 150
    }
    public OrientacionCurricular save(OrientacionCurricular orientacion) {
        return repository.save(orientacion);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}