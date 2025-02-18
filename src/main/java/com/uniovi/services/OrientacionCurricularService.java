package com.uniovi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.OrientacionCurricular;
import com.uniovi.repositories.OrientacionCurricularRepository;

@Service
public class OrientacionCurricularService {

    @Autowired
    private OrientacionCurricularRepository repository;

    public List<OrientacionCurricular> getAll() {
        return repository.findAll();
    }

    public Optional<OrientacionCurricular> getById(Long id) {
        return repository.findById(id);
    }

    public OrientacionCurricular save(OrientacionCurricular orientacion) {
        return repository.save(orientacion);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}