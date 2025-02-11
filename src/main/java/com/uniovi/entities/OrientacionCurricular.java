package com.uniovi.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orientaciones_curriculares")
public class OrientacionCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    
    private LocalDate fecha;
    
    private int numParticipantes;

    // Constructores
    public OrientacionCurricular() {}

    public OrientacionCurricular(String titulo, LocalDate fecha, int numParticipantes) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.numParticipantes = numParticipantes;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public int getNumParticipantes() { return numParticipantes; }
    public void setNumParticipantes(int numParticipantes) { this.numParticipantes = numParticipantes; }
}
