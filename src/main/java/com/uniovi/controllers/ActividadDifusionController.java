package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.ActividadDifusion;
import com.uniovi.services.ActividadDifusionService;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadDifusionController {

    private final ActividadDifusionService service;

    @Autowired
    public ActividadDifusionController(ActividadDifusionService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActividadDifusion> getAllActividades() {
        return service.getAllActividades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadDifusion> getActividadById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getActividadById(id));
    }

    @PostMapping
    public ResponseEntity<ActividadDifusion> createActividad(@RequestBody ActividadDifusion actividad) {
        return ResponseEntity.ok(service.saveActividad(actividad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadDifusion> updateActividad(@PathVariable Long id, @RequestBody ActividadDifusion actividad) {
        ActividadDifusion existing = service.getActividadById(id);
        existing.setFecha(actividad.getFecha());
        existing.setNombre(actividad.getNombre());
        existing.setParticipantes(actividad.getParticipantes());
        return ResponseEntity.ok(service.saveActividad(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActividad(@PathVariable Long id) {
        service.deleteActividad(id);
        return ResponseEntity.noContent().build();
    }
}
