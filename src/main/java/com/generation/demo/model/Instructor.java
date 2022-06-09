package com.generation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="id_instructor")
	private Integer id;
	
	@Column(nullable = false, name="nombre")
	private String nombre;
	
	@Column(nullable = false, name="supervisor")
	private String supervisor;
	
	@Column(nullable = false, name="puesto")
	private String puesto;
	
	//Llave foranea
	@OneToOne
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

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Cohorte getCohorte() {
		return cohorte;
	}

	public void setCohorte(Cohorte cohorte) {
		this.cohorte = cohorte;
	}
	
	
}
