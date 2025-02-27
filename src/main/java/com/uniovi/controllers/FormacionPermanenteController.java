package com.uniovi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.FormacionPermanente;
import com.uniovi.services.FormacionPermanenteService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/formacion")
public class FormacionPermanenteController {
	
    @Autowired
    private FormacionPermanenteService service;
    
    @GetMapping
    public List<FormacionPermanente> getAll() {
        return service.getAllFormaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormacionPermanente> getById(@PathVariable Long id) {
        Optional<FormacionPermanente> formacion = service.getFormacionById(id);
        return formacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/media")
    public Map<String, Double> obtenerMedia(@RequestParam String startDate, @RequestParam String endDate) {
        Double media = service.calcularMediaPorcentaje(LocalDate.parse(startDate), LocalDate.parse(endDate));
        return Map.of("mediaPorcentaje", media != null ? media : 0.0);
    }
    @PostMapping
    public FormacionPermanente create(@RequestBody FormacionPermanente formacion) {
        return service.saveFormacion(formacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormacionPermanente> update(@PathVariable Long id, @RequestBody FormacionPermanente formacion) {
        try {
            return ResponseEntity.ok(service.updateFormacion(id, formacion));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteFormacion(id);
        return ResponseEntity.noContent().build();
    }
}
