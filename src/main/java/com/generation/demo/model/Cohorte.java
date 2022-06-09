package com.generation.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //representacion de la informacion que nosotros necesitamos
@Table(name = "cohorte")
public class Cohorte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="id_cohorte")
	private Integer id;
	
	@Column(nullable = false, name="numero_cohorte")
	private Integer numeroCohorte;
	
	@Column(nullable = false, name="ciudad")
	private String ciudad;
	

	//Especificar la union con alumno
	@OneToMany(mappedBy = "cohorte")
	private List<Alumno> alumnos;
	
	//Especificar la union con instructor
	@OneToOne(mappedBy = "cohorte")
	private Instructor instructor;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumeroCohorte() {
		return numeroCohorte;
	}
	public void setNumeroCohorte(Integer numeroCohorte) {
		this.numeroCohorte = numeroCohorte;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	
}
