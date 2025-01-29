package com.uniovi.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Indices")
public class Indice {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 
	    @Column(nullable = false, length = 255)
	    private String nombre;

	    @Column(nullable = false)
	    private LocalDate fecha_de_inicio;
	    
	    @Column(nullable = false)
	    private LocalDate fecha_de_fin;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Indice() {
			super();
		}

		public Indice(Integer id, String nombre, LocalDate fecha_de_inicio, LocalDate fecha_de_fin) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.fecha_de_inicio = fecha_de_inicio;
			this.fecha_de_fin = fecha_de_fin;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public LocalDate getFecha_de_inicio() {
			return fecha_de_inicio;
		}

		public void setFecha_de_inicio(LocalDate fecha_de_inicio) {
			this.fecha_de_inicio = fecha_de_inicio;
		}

		public LocalDate getFecha_de_fin() {
			return fecha_de_fin;
		}

		public void setFecha_de_fin(LocalDate fecha_de_fin) {
			this.fecha_de_fin = fecha_de_fin;
		}
	    
	    
}
