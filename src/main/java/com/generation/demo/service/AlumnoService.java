package com.generation.demo.service;

import java.util.List;

import com.generation.demo.model.Alumno;

public interface AlumnoService {

	
	Alumno getAlumno(Integer id);
	List<Alumno> getAlumnos();
	
	Alumno saveAlumno(Alumno alumno);
	
	Boolean deleteAlumno(Integer id);
	
	Alumno updateAlumno(Alumno alumno);
}
