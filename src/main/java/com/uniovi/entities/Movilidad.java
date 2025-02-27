package com.uniovi.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Movilidad {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable = false)
	    private LocalDate fecha;
	    @Column(nullable = false)
	    private int plazasOfertadas;
	    @Column(nullable = false)
	    private int plazasCubiertas;

	    public Movilidad() {
			super();
		}
		public Movilidad(Long id, LocalDate fecha, int plazasOfertadas, int plazasCubiertas) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.plazasOfertadas = plazasOfertadas;
			this.plazasCubiertas = plazasCubiertas;
		}
		// Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public LocalDate getFecha() { return fecha; }
	    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

	    public int getPlazasOfertadas() { return plazasOfertadas; }
	    public void setPlazasOfertadas(int plazasOfertadas) { this.plazasOfertadas = plazasOfertadas; }

	    public int getPlazasCubiertas() { return plazasCubiertas; }
	    public void setPlazasCubiertas(int plazasCubiertas) { this.plazasCubiertas = plazasCubiertas; }
}
