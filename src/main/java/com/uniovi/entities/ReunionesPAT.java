package com.uniovi.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reuniones_pat")
public class ReunionesPAT {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private Integer numero;
    private Integer numeroReuniones;

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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumeroReuniones() {
        return numeroReuniones;
    }

    public void setNumeroReuniones(Integer numeroReuniones) {
        this.numeroReuniones = numeroReuniones;
    }
}
