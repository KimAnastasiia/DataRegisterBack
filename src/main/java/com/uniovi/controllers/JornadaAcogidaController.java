package com.uniovi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.uniovi.entities.JornadaAcogida;
import com.uniovi.entities.Visita;
import com.uniovi.services.JornadaAcogidaService;
import java.time.LocalDate;
@RestController
@RequestMapping("/api/jornadas")
public class JornadaAcogidaController {
	    @Autowired
	    private JornadaAcogidaService service;
	    
	    @GetMapping
	    public List<JornadaAcogida> getAll() { return service.findAll(); }
	    
	    @GetMapping("/indice")
	    public ResponseEntity<Map<String, Object>>  getStatistics(
	            @RequestParam("startDate") String startDate, 
	            @RequestParam("endDate") String endDate) {
	        
	        LocalDate start = LocalDate.parse(startDate);
	        LocalDate end = LocalDate.parse(endDate);

	        List<JornadaAcogida> jornadaAcogida =  service.getStatistics(start, end);
	        
	        int totalParticipantes = jornadaAcogida.stream()
                    .mapToInt(JornadaAcogida::getParticipantes)
                    .sum();

			int maxParticipants = 150;
			    double percentage = (totalParticipantes / (double) maxParticipants) * 100;
			    
			// Prepare the response
			Map<String, Object> response = new HashMap<>();
			response.put("percentageParticipantes", percentage);
			return ResponseEntity.ok(response);
	    }
	    @PostMapping
	    public JornadaAcogida create(@RequestBody JornadaAcogida jornada) { return service.save(jornada); }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<JornadaAcogida> editJornadaAcogida(
	            @PathVariable("id") Long id, 
	            @RequestBody JornadaAcogida jornadaAcogidaDetails) {
	        
	        JornadaAcogida updatedJornada = service.updateJornadaAcogida(id, jornadaAcogidaDetails);
	        
	        if (updatedJornada != null) {
	            return new ResponseEntity<>(updatedJornada, HttpStatus.OK);
	        }
	        
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // If not found, return 404
	    }
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) { service.delete(id); }
}
