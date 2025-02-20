package com.uniovi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.uniovi.entities.JornadaAcogida;
import com.uniovi.entities.Visita;
import com.uniovi.repositories.JornadaAcogidaRepository;

@Service
public class JornadaAcogidaService {
    @Autowired
    private JornadaAcogidaRepository repository;
    
    public List<JornadaAcogida> findAll() { return repository.findAll(); }
    
    public List<JornadaAcogida> getStatistics(LocalDate startDate, LocalDate endDate) {
        // Get all JornadaAcogida entries between startDate and endDate
        return repository.findByFechaBetween(startDate, endDate);
        

    }
    public JornadaAcogida save(JornadaAcogida jornada) { return repository.save(jornada); }
    
    public JornadaAcogida updateJornadaAcogida(Long id, JornadaAcogida jornadaAcogidaDetails) {
        Optional<JornadaAcogida> optionalJornada = repository.findById(id);
        
        if (optionalJornada.isPresent()) {
            JornadaAcogida jornada = optionalJornada.get();
            jornada.setFecha(jornadaAcogidaDetails.getFecha());
            jornada.setParticipantes(jornadaAcogidaDetails.getParticipantes());
            jornada.setValoracion(jornadaAcogidaDetails.getValoracion());
            
            return repository.save(jornada);
        }
        
        return null; // Return null if JornadaAcogida with the given id is not found
    }
    public void delete(Long id) { repository.deleteById(id); }
}
