package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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
