package com.uniovi.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Actividades_de_difusion")
public class ActividadDifusion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false)
    private Integer participantes;


    public ActividadDifusion() {
		super();
	}

	public ActividadDifusion(Integer id, LocalDate fecha, String nombre, Integer participantes) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.nombre = nombre;
		this.participantes = participantes;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }
}
