package com.uniovi.controllers;

import com.uniovi.entities.Bilingue;
import com.uniovi.services.BilingueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/bilingue")
public class BilingueController {
	 @Autowired
	    private BilingueService service;

	    @GetMapping
	    public List<Bilingue> getAll() {
	        return service.getAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Bilingue> getById(@PathVariable Long id) {
	        Optional<Bilingue> bilingue = service.getById(id);
	        return bilingue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Bilingue create(@RequestBody Bilingue bilingue) {
	        return service.save(bilingue);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Bilingue> update(@PathVariable Long id, @RequestBody Bilingue bilingue) {
	        Bilingue updated = service.update(id, bilingue);
	        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/range")
	    public Map<String, Integer> getByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
	        return service.findByFechaRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
	    }
}
