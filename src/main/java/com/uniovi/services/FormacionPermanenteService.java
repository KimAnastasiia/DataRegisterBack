package com.uniovi.services;
import org.springframework.stereotype.Service;

import com.uniovi.entities.FormacionPermanente;
import com.uniovi.repositories.FormacionPermanenteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class FormacionPermanenteService {
	
	    private final FormacionPermanenteRepository repository;

	    public FormacionPermanenteService(FormacionPermanenteRepository repository) {
	        this.repository = repository;
	    }
	    public List<FormacionPermanente> getAllFormaciones() {
	        return repository.findAll();
	    }

	    public Optional<FormacionPermanente> getFormacionById(Long id) {
	        return repository.findById(id);
	    }
	    public Double calcularMediaPorcentaje(LocalDate startDate, LocalDate endDate) {
	        return repository.calcularMediaPorcentaje(startDate, endDate);
	    }
	    public FormacionPermanente saveFormacion(FormacionPermanente formacion) {
	        return repository.save(formacion);
	    }

	    public FormacionPermanente updateFormacion(Long id, FormacionPermanente nuevaFormacion) {
	        return repository.findById(id).map(formacion -> {
	            formacion.setFecha(nuevaFormacion.getFecha());
	            formacion.setPorcentajeParticipacion(nuevaFormacion.getPorcentajeParticipacion());
	            return repository.save(formacion);
	        }).orElseThrow(() -> new RuntimeException("Formación no encontrada"));
	    }

	    public void deleteFormacion(Long id) {
	        repository.deleteById(id);
	    }
}
