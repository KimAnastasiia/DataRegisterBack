package com.uniovi.controllers;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.Indice;
import com.uniovi.services.IndiceService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/api/indices")
public class IndiceController {
	   @Autowired
	    private IndiceService indiceService;

	    // GET: Retrieve all indices
	    @GetMapping
	    public List<Indice> getAllIndices() {
	        return indiceService.getAllIndices();
	    }

	    // GET: Retrieve a single indice by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Indice> getIndiceById(@PathVariable Integer id) {
	        return indiceService.getIndiceById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // POST: Create a new indice
	    @PostMapping
	    public Indice createIndice(@RequestBody Indice indice) {
	        return indiceService.saveIndice(indice);
	    }

	    // PUT: Update an existing indice
	    @PutMapping("/{id}")
	    public ResponseEntity<Indice> updateIndice(@PathVariable Integer id, @RequestBody Indice indice) {
	        return indiceService.getIndiceById(id).map(existingIndice -> {
	            existingIndice.setNombre(indice.getNombre());
	            existingIndice.setFecha_de_inicio(indice.getFecha_de_inicio());
	            existingIndice.setFecha_de_fin(indice.getFecha_de_fin());
	            Indice updatedIndice = indiceService.saveIndice(existingIndice);
	            return ResponseEntity.ok(updatedIndice);
	        }).orElse(ResponseEntity.notFound().build());
	    }

	    // DELETE: Delete an indice
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteIndice(@PathVariable Integer id) {
	        if (indiceService.getIndiceById(id).isPresent()) {
	            indiceService.deleteIndice(id);
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.notFound().build();
	    }
}
