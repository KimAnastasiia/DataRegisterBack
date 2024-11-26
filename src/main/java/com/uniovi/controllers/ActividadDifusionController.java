package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.ActividadDifusion;
import com.uniovi.entities.Visita;
import com.uniovi.services.ActividadDifusionService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/fecha")
    public ResponseEntity<Map<String, Object>> getActividadesBetweenDates(
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        // Parse dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        // Retrieve data
        Pageable pageable = PageRequest.of(page - 1, size); // Page index is 0-based in Spring
        Page<ActividadDifusion> actividadesPage = service.getActividadesBetweenDates(startDate, endDate, pageable);

        // Prepare the response
        Map<String, Object> response = new HashMap<>();
        response.put("items", actividadesPage.getContent()); // Current page data
        response.put("total", actividadesPage.getTotalElements()); // Total number of items

        return ResponseEntity.ok(response);
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
    public ResponseEntity<String> updateActividad(@PathVariable Long id, @RequestBody ActividadDifusion actividad) {
        // Check if the ActividadDifusion exists
    	try {
    		  	ActividadDifusion existing = service.getActividadById(id);
    		  	existing.setFecha(actividad.getFecha());
    	        existing.setNombre(actividad.getNombre());
    	        existing.setParticipantes(actividad.getParticipantes());
    	        
    	        // Save the updated entity
    	        ActividadDifusion updated = service.saveActividad(existing);
    	        
    	        // Return a success message with 200 OK
    	        return ResponseEntity.ok("Actividad with id " + id + " successfully updated.");
    	}catch (Exception e) {
      	  return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body("Actividad with id " + id + " not found.");
    	}
      
        

       
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActividad(@PathVariable Long id) {
    	
        	try {

        		ActividadDifusion actividad = service.getActividadById(id);
	            if (actividad !=null) {   
	            	  service.deleteActividad(id); // Delete if found
	                  return ResponseEntity.ok("Actividad with id " + id + " successfully deleted.");
	              
	            } 
        	}catch (Exception e) {
            	  return ResponseEntity.status(HttpStatus.NOT_FOUND)
                          .body("Actividad with id " + id + " not found.");
            }
        	
    
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the actividad.");
       

    }


}
