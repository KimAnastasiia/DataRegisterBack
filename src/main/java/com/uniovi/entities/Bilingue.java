package com.uniovi.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bilingue")
public class Bilingue {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;
    
    @Column(nullable = false)
    private int estudiantesTotales;
    
    @Column(nullable = false)
    private int estudiantesEnIngles;
    
    
	public Bilingue() {
		super();
	}

	public Bilingue(Long id, LocalDate fecha, int estudiantesTotales, int estudiantesEnIngles) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estudiantesTotales = estudiantesTotales;
		this.estudiantesEnIngles = estudiantesEnIngles;
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



	public int getEstudiantesTotales() {
		return estudiantesTotales;
	}



	public void setEstudiantesTotales(int estudiantesTotales) {
		this.estudiantesTotales = estudiantesTotales;
	}



	public int getEstudiantesEnIngles() {
		return estudiantesEnIngles;
	}



	public void setEstudiantesEnIngles(int estudiantesEnIngles) {
		this.estudiantesEnIngles = estudiantesEnIngles;
	}


}
