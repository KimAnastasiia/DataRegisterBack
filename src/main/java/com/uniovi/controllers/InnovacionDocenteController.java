package com.uniovi.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.InnovacionDocente;
import com.uniovi.services.InnovacionDocenteService;

@RestController
@RequestMapping("/api/innovacion-docente")

public class InnovacionDocenteController {
	 @Autowired
	 private InnovacionDocenteService service;
	 
	    @GetMapping
	    public List<InnovacionDocente> getAll() {
	        return service.getAll();
	    }
	    
	    @GetMapping("/media/average")
	    public Double getAverage(@RequestParam String startDate, @RequestParam String endDate) {
	         LocalDate start = LocalDate.parse(startDate);
	         LocalDate end = LocalDate.parse(endDate);
	         return Optional.ofNullable(service.getAverageParticipation(start, end)).orElse(0.0);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<InnovacionDocente> getById(@PathVariable Long id) {
	        Optional<InnovacionDocente> result = service.getById(id);
	        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    @PostMapping
	    public InnovacionDocente save(@RequestBody InnovacionDocente innovacionDocente) {
	        return service.save(innovacionDocente);
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<InnovacionDocente> update(@PathVariable Long id, @RequestBody InnovacionDocente updatedDocente) {
	        Optional<InnovacionDocente> result = service.update(id, updatedDocente);
	        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        boolean deleted = service.delete(id);
	        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	    }
}
