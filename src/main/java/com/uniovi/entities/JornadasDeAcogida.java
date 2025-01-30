package com.uniovi.entities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Table(name = "jornadas_acogida")
class JornadaAcogida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fecha;
    @Column(nullable = false)
    private Integer participantes;
    @Column(nullable = false)
    private Integer valoracion;
    
	public JornadaAcogida(Long id, String fecha, Integer participantes, Integer valoracion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.participantes = participantes;
		this.valoracion = valoracion;
	}

	public JornadaAcogida() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Integer participantes) {
		this.participantes = participantes;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}


}