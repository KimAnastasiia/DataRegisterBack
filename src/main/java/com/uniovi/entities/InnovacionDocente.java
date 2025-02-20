package com.uniovi.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "innovacion_docente")
public class InnovacionDocente {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable = false)
	    private LocalDate fecha;
	    
	    @Column(nullable = false)
	    private Double porcentajeProfesoresParticipantes;

	    
		public InnovacionDocente() {
			super();
		}


		public InnovacionDocente(Long id, LocalDate fecha, Double porcentajeProfesoresParticipantes) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.porcentajeProfesoresParticipantes = porcentajeProfesoresParticipantes;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public LocalDate getFecha() {
			return fecha;
		}


		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}


		public Double getPorcentajeProfesoresParticipantes() {
			return porcentajeProfesoresParticipantes;
		}


		public void setPorcentajeProfesoresParticipantes(Double porcentajeProfesoresParticipantes) {
			this.porcentajeProfesoresParticipantes = porcentajeProfesoresParticipantes;
		}
	    
	    
}
