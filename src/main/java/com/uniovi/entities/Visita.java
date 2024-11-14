package com.uniovi.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "visitas")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "participantes", nullable = false)
    private Integer participantes;

    @Column(name = "colegio", nullable = false, length = 100)
    private String colegio;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    // Constructor vacío (necesario para JPA)
    public Visita() {}

    // Constructor con parámetros
    public Visita(Integer participantes, String colegio, LocalDate fecha) {
        this.participantes = participantes;
        this.colegio = colegio;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Visita{" +
                "id=" + id +
                ", participantes=" + participantes +
                ", colegio='" + colegio + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}