package com.uniovi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Bilingue;
import com.uniovi.repositories.BilingueRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BilingueService {
	@Autowired
    private BilingueRepository repository;

    public List<Bilingue> getAll() {
        return repository.findAll();
    }

    public Optional<Bilingue> getById(Long id) {
        return repository.findById(id);
    }

    public Bilingue save(Bilingue bilingue) {
        return repository.save(bilingue);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Bilingue update(Long id, Bilingue bilingue) {
        if (repository.existsById(id)) {
            bilingue.setId(id);
            return repository.save(bilingue);
        }
        return null;
    }

    public Map<String, Integer> findByFechaRange(LocalDate startDate, LocalDate endDate) {
    	  List<Bilingue> records = repository.findByFechaBetween(startDate, endDate);
    	  int totalEstudiantes = records.stream().mapToInt(Bilingue::getEstudiantesTotales).sum();
          int totalEnIngles = records.stream().mapToInt(Bilingue::getEstudiantesEnIngles).sum();

          Map<String, Integer> response = new HashMap<>();
          response.put("estudiantes_totales", totalEstudiantes);
          response.put("estudiantes_en_ingles", totalEnIngles);

          return response;
        
    }
}
