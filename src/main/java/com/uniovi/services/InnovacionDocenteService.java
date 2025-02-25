package com.uniovi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.InnovacionDocente;
import com.uniovi.repositories.InnovacionDocenteRepository;

@Service
public class InnovacionDocenteService {
	
	@Autowired
    private InnovacionDocenteRepository repository;

    public List<InnovacionDocente> getAll() {
        return repository.findAll();
    }
    public Double getAverageParticipation(LocalDate startDate, LocalDate endDate) {
        return repository.findAverageParticipation(startDate, endDate);
    }
    public Optional<InnovacionDocente> getById(Long id) {
        return repository.findById(id);
    }

    public InnovacionDocente save(InnovacionDocente innovacionDocente) {
        return repository.save(innovacionDocente);
    }
    public Optional<InnovacionDocente> update(Long id, InnovacionDocente updatedDocente) {
        return repository.findById(id).map(existingDocente -> {
            existingDocente.setFecha(updatedDocente.getFecha());
            existingDocente.setPorcentajeProfesoresParticipantes(updatedDocente.getPorcentajeProfesoresParticipantes());
            return repository.save(existingDocente);
        });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
