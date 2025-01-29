package com.uniovi.controllers;
import com.uniovi.entities.Visita;
import com.uniovi.services.VisitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @GetMapping("/fecha")
    public ResponseEntity<Map<String, Object>> getVisitasBetweenDates(
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        // Parse dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        // Retrieve data (assuming you have a service that supports pagination)
        Pageable pageable = PageRequest.of(page - 1, size); // Page index is 0-based in Spring
        Page<Visita> visitas = visitaService.getVisitasBetweenDates(startDate, endDate, pageable);

        // Prepare the response
        Map<String, Object> response = new HashMap<>();
        response.put("items", visitas.getContent()); // Current page data
        response.put("total", visitas.getTotalElements()); // Total number of items

        return ResponseEntity.ok(response);
    }
    @GetMapping("/indice")
    public ResponseEntity<Map<String, Object>> getStatisticsBetweenDates(
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr) {

        // Parse dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        // Calculate total participants and total visits
        List<Visita> visitas = visitaService.getVisitasBetweenDates(startDate, endDate);
        int totalParticipantes = visitas.stream()
                                        .mapToInt(Visita::getParticipantes)
                                        .sum();
        long totalVisitas = visitas.size();

        // Prepare the response
        Map<String, Object> response = new HashMap<>();
        response.put("totalParticipantes", totalParticipantes);
        response.put("totalVisitas", totalVisitas);

        return ResponseEntity.ok(response);
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