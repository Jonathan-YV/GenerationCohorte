package com.generation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="id_alumno")
	private Integer id;
	
	@Column(nullable = false, name="nombre")
	private String nombre;
	
	@Column(nullable = false, name="edad")
	private Integer edad;
	
	@Column(nullable = false, unique = true, name="correo")
	private String correo;
	
	
	//Llave foranea 
	//Estamos relacionando el alumno con la cohorte
	//Necesitamos especificar la relacion
	
	@ManyToOne
	@JoinColumn(nullable = false, name="cohorte_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cohorte cohorte;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Cohorte getCohorte() {
		return cohorte;
	}


	public void setCohorte(Cohorte cohorte) {
		this.cohorte = cohorte;
	}
	
	
	
	
	
	
	

}
