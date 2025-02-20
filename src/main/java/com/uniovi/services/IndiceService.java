package com.uniovi.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Indice;
import com.uniovi.repositories.IndiceRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IndiceService {
	    @Autowired
	    private IndiceRepository indiceRepository;

	    public List<Indice> getAllIndices() {
	        return indiceRepository.findAll();
	    }

	    public Optional<Indice> getIndiceById(Integer id) {
	        return indiceRepository.findById(id);
	    }
	    
	    
	    public Indice saveIndice(Indice indice) {
	        return indiceRepository.save(indice);
	    }

	    public void deleteIndice(Integer id) {
	        indiceRepository.deleteById(id);
	    }
}
