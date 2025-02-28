package com.uniovi.services;
import com.uniovi.entities.Movilidad;
import com.uniovi.repositories.MovilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovilidadService {
	    @Autowired
	    private MovilidadRepository movilidadRepository;

	    public List<Movilidad> getAll() {
	        return movilidadRepository.findAll();
	    }

	    public Optional<Movilidad> getById(Long id) {
	        return movilidadRepository.findById(id);
	    }
	    public Double calculateIndicador(LocalDate startDate, LocalDate endDate) {
	        return movilidadRepository.getIndicador(startDate, endDate);
	    }
	    public Movilidad save(Movilidad movilidad) {
	        return movilidadRepository.save(movilidad);
	    }

	    public void delete(Long id) {
	        movilidadRepository.deleteById(id);
	    }


}
