package com.uniovi.entities;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "presupuesto_laboratorio")
public class PresupuestoLaboratorio {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private LocalDate fecha;
	    
	    private Double presupuestoTotal;
	    
	    private Double presupuestoLaboratorios;

	    public PresupuestoLaboratorio() {
			super();
		}

		public PresupuestoLaboratorio(Long id, LocalDate fecha, Double presupuestoTotal,
				Double presupuestoLaboratorios) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.presupuestoTotal = presupuestoTotal;
			this.presupuestoLaboratorios = presupuestoLaboratorios;
		}

		// Getters y Setters
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

	    public Double getPresupuestoTotal() {
	        return presupuestoTotal;
	    }

	    public void setPresupuestoTotal(Double presupuestoTotal) {
	        this.presupuestoTotal = presupuestoTotal;
	    }

	    public Double getPresupuestoLaboratorios() {
	        return presupuestoLaboratorios;
	    }

	    public void setPresupuestoLaboratorios(Double presupuestoLaboratorios) {
	        this.presupuestoLaboratorios = presupuestoLaboratorios;
	    }
}
