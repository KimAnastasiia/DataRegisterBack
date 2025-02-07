package com.uniovi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.PresupuestoLaboratorio;
import com.uniovi.services.PresupuestoLaboratorioService;

@RestController
@RequestMapping("/api/presupuesto-laboratorio")
public class PresupuestoLaboratorioController {
	@Autowired
    private PresupuestoLaboratorioService service;

    @GetMapping
    public List<PresupuestoLaboratorio> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PresupuestoLaboratorio> getById(@PathVariable Long id) {
        Optional<PresupuestoLaboratorio> presupuesto = service.getById(id);
        return presupuesto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PresupuestoLaboratorio create(@RequestBody PresupuestoLaboratorio presupuesto) {
        return service.create(presupuesto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PresupuestoLaboratorio> update(@PathVariable Long id, @RequestBody PresupuestoLaboratorio newPresupuesto) {
        return service.update(id, newPresupuesto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
