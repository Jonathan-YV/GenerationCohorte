package com.generation.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.demo.model.Alumno;
import com.generation.demo.service.AlumnoService;

@RestController
@RequestMapping("api/alumno")
public class AlumnoController {

	AlumnoService alumnoService;
	
	public AlumnoController(@Autowired AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}
	
	@GetMapping("/{id}")
	public Alumno getAlumno(@PathVariable Integer id) {
		return alumnoService.getAlumno(id);
	}
	
	@GetMapping("/all")
	public List<Alumno> getCohortes(){
		return alumnoService.getAlumnos();
	}
	
	
	// Escribir 
	@PostMapping
	public Alumno saveAlumno(@RequestBody Alumno alumno) {
		return alumnoService.saveAlumno(alumno);
	}
	
	// Borrar
	@DeleteMapping("delete/{id}")
	public void deleteAlumno(@PathVariable Integer id) {
		alumnoService.deleteAlumno(id);
	}
	
	// Actualizar
	@PutMapping
	public Alumno updateAlumno(@RequestBody Alumno alumno) {
		return alumnoService.updateAlumno(alumno);
	}
}
