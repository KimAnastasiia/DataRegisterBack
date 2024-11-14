package com.uniovi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Visita;
import com.uniovi.repositories.VisitaRepository;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    // Get all visitas
    public List<Visita> getAllVisitas() {
        return visitaRepository.findAll();
    }

    // Get a visita by ID
    public Optional<Visita> getVisitaById(Long id) {
        return visitaRepository.findById(id);
    }
    public List<Visita> getVisitasBetweenDates(LocalDate startDate, LocalDate endDate) {
        return visitaRepository.findByFechaBetween(startDate, endDate);
    }
    // Create a new visita
    public Visita createVisita(Visita visita) {
        return visitaRepository.save(visita);
    }

    // Update an existing visita
    public Visita updateVisita(Long id, Visita visitaDetails) {
        Optional<Visita> existingVisita = visitaRepository.findById(id);
        if (existingVisita.isPresent()) {
            Visita visita = existingVisita.get();
            visita.setParticipantes(visitaDetails.getParticipantes());
            visita.setColegio(visitaDetails.getColegio());
            visita.setFecha(visitaDetails.getFecha());
            return visitaRepository.save(visita);
        } else {
            return null;  // Or throw an exception
        }
    }

    // Delete a visita by ID
    public void deleteVisita(Long id) {
        visitaRepository.deleteById(id);
    }
}