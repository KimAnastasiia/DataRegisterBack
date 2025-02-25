package com.uniovi.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "formacion_permanente")
public class FormacionPermanente {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate fecha;
	    private Double porcentajeParticipacion;

	    
	    public FormacionPermanente() {
			super();
		}

		public FormacionPermanente(Long id, LocalDate fecha, Double porcentajeParticipacion) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.porcentajeParticipacion = porcentajeParticipacion;
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

	    public Double getPorcentajeParticipacion() {
	        return porcentajeParticipacion;
	    }

	    public void setPorcentajeParticipacion(Double porcentajeParticipacion) {
	        this.porcentajeParticipacion = porcentajeParticipacion;
	    }
}
