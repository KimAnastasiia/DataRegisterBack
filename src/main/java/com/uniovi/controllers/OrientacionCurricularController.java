package com.uniovi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.OrientacionCurricular;
import com.uniovi.services.OrientacionCurricularService;

@RestController
@RequestMapping("/api/orientaciones")
@CrossOrigin(origins = "*") // Permitir solicitudes desde el frontend
public class OrientacionCurricularController {

    @Autowired
    private OrientacionCurricularService service;

    @GetMapping
    public List<OrientacionCurricular> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrientacionCurricular> getById(@PathVariable Long id) {
        Optional<OrientacionCurricular> orientacion = service.getById(id);
        return orientacion.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrientacionCurricular create(@RequestBody OrientacionCurricular orientacion) {
        return service.save(orientacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrientacionCurricular> update(@PathVariable Long id, @RequestBody OrientacionCurricular newOrientacion) {
        return service.getById(id)
                .map(existing -> {
                    existing.setTitulo(newOrientacion.getTitulo());
                    existing.setFecha(newOrientacion.getFecha());
                    existing.setNumParticipantes(newOrientacion.getNumParticipantes());
                    return ResponseEntity.ok(service.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}