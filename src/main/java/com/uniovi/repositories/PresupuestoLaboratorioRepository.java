package com.uniovi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniovi.entities.PresupuestoLaboratorio;

@Repository
public interface PresupuestoLaboratorioRepository extends JpaRepository<PresupuestoLaboratorio, Long> {}