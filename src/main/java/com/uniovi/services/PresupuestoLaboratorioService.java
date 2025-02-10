package com.uniovi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.PresupuestoLaboratorio;
import com.uniovi.repositories.PresupuestoLaboratorioRepository;

@Service
public class PresupuestoLaboratorioService {
	
	    @Autowired
	    private PresupuestoLaboratorioRepository repository;

	    public Optional<PresupuestoLaboratorio> getById(Long id) {
	        return repository.findById(id);
	    }

	    public List<PresupuestoLaboratorio> getAll() {
	        return repository.findAll();
	    }
	    public Double calcularPorcentajeGastoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
	        Double totalPresupuesto = repository.sumarPresupuestoTotalEntreFechas(fechaInicio, fechaFin);
	        Double totalLaboratorio = repository.sumarPresupuestoLaboratoriosEntreFechas(fechaInicio, fechaFin);
	        if (totalPresupuesto == null || totalPresupuesto == 0) {
	            return 0.0;
	        }
	        return (totalLaboratorio / totalPresupuesto) * 100;
	        
	   }
	    public PresupuestoLaboratorio create(PresupuestoLaboratorio presupuesto) {
	        return repository.save(presupuesto);
	    }

	    public Optional<PresupuestoLaboratorio> update(Long id, PresupuestoLaboratorio newPresupuesto) {
	        return repository.findById(id).map(presupuesto -> {
	            presupuesto.setFecha(newPresupuesto.getFecha());
	            presupuesto.setPresupuestoTotal(newPresupuesto.getPresupuestoTotal());
	            presupuesto.setPresupuestoLaboratorios(newPresupuesto.getPresupuestoLaboratorios());
	            return repository.save(presupuesto);
	        });
	    }

	    public boolean delete(Long id) {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
