package com.uniovi.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.ReunionesPAT;
import com.uniovi.services.ReunionesPATService;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones-pat")
public class ReunionesPATController {
	
	 private final ReunionesPATService service;

	    public ReunionesPATController(ReunionesPATService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<ReunionesPAT> getAll() {
	        return service.getAll();
	    }

	    @PostMapping
	    public ReunionesPAT createReunion(@RequestBody ReunionesPAT reunion) {
	        return service.save(reunion);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<ReunionesPAT> update(@PathVariable Long id, @RequestBody ReunionesPAT updatedMeeting) {
	        ReunionesPAT meeting = service.updateReunion(id, updatedMeeting);
	        if (meeting != null) {
	            return ResponseEntity.ok(meeting);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> delete(@PathVariable Long id) {
	        if (service.deleteReunion(id)) {
	            return ResponseEntity.ok("Reunion deleted successfully");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
