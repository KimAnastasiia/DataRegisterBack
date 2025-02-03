package com.uniovi.services;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uniovi.entities.ReunionesPAT;
import com.uniovi.repositories.ReunionesPATRepository;

@Service
public class ReunionesPATService {
	  private final ReunionesPATRepository repository;

	    public ReunionesPATService(ReunionesPATRepository repository) {
	        this.repository = repository;
	    }

	    public List<ReunionesPAT> getAll() {
	        return repository.findAll();
	    }
	    public Integer getTotalReuniones(LocalDate inicio, LocalDate fin) {
	        return repository.getSumReuniones(inicio, fin);
	    }
	    public ReunionesPAT save(ReunionesPAT reunion) {
	        return repository.save(reunion);
	    }
	    public ReunionesPAT updateReunion(Long id, ReunionesPAT updatedMeeting) {
	        Optional<ReunionesPAT> existingMeeting = repository.findById(id);
	        if (existingMeeting.isPresent()) {
	            ReunionesPAT meeting = existingMeeting.get();
	            meeting.setFecha(updatedMeeting.getFecha());
	            meeting.setNumero(updatedMeeting.getNumero());
	            meeting.setNumeroReuniones(updatedMeeting.getNumeroReuniones());
	            return repository.save(meeting);
	        }
	        return null; // Return null if meeting is not found (handled in controller)
	    }
	    
	    public boolean deleteReunion(Long id) {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
