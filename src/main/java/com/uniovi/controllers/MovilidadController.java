package com.uniovi.controllers;
import com.uniovi.entities.Movilidad;
import com.uniovi.services.MovilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/movilidad")
public class MovilidadController {

    @Autowired
    private MovilidadService movilidadService;

    @GetMapping
    public List<Movilidad> getAll() {
        return movilidadService.getAll();
    }
    @GetMapping("/indicador")
    public ResponseEntity<Map<String, Object>> getIndicador(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        Double indicador = movilidadService.calculateIndicador(start, end);

        Map<String, Object> response = new HashMap<>();
        response.put("indicador", indicador != null ? indicador : 0.0);

        return ResponseEntity.ok(response);
        
    }
    @GetMapping("/{id}")
    public Optional<Movilidad> getById(@PathVariable Long id) {
        return movilidadService.getById(id);
    }

    @PostMapping
    public Movilidad create(@RequestBody Movilidad movilidad) {
        return movilidadService.save(movilidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>  update(@PathVariable Long id, @RequestBody Movilidad movilidad) {
    	Optional<Movilidad> existingMovilidad = movilidadService.getById(id);
        if (existingMovilidad.isPresent()) {
	        movilidad.setId(id);
	        Movilidad updatedMovilidad = movilidadService.save(movilidad);
	        return ResponseEntity.ok(updatedMovilidad);
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movilidad with ID " + id + " not found.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
    	   Map<String, Object> response = new HashMap<>();
     
        Optional<Movilidad> existingMovilidad = movilidadService.getById(id);
        
        if (existingMovilidad.isPresent()) {
            movilidadService.delete(id);
            response.put("message", "Movilidad with ID " + id + " deleted successfully.");
            response.put("status", HttpStatus.OK.value()); 
            return ResponseEntity.ok(response); 
         
        }
        response.put("message", "Movilidad with ID " + id + " not found.");
        response.put("status", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}
