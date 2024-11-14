package com.uniovi.controllers;
import com.uniovi.entities.Visita;
import com.uniovi.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/visitas")  // Base URL for this controller
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    // Get all visitas
    @GetMapping
    public List<Visita> getAllVisitas() {
        return visitaService.getAllVisitas();
    }

    // Get a visita by ID
    @GetMapping("/{id}")
    public ResponseEntity<Visita> getVisitaById(@PathVariable Long id) {
        Optional<Visita> visita = visitaService.getVisitaById(id);
        return visita.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new visita
    @PostMapping
    public ResponseEntity<Visita> createVisita(@RequestBody Visita visita) {
        Visita newVisita = visitaService.createVisita(visita);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVisita);
    }

    // Update an existing visita
    @PutMapping("/{id}")
    public ResponseEntity<Visita> updateVisita(@PathVariable Long id, @RequestBody Visita visitaDetails) {
        Visita updatedVisita = visitaService.updateVisita(id, visitaDetails);
        return updatedVisita != null ? ResponseEntity.ok(updatedVisita) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a visita by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisita(@PathVariable Long id) {
        visitaService.deleteVisita(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}