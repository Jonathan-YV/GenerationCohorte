package com.generation.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.demo.model.Instructor;
import com.generation.demo.service.InstructorService;

@RestController
@RequestMapping("api/instructor")
public class InstructorController {
	
	InstructorService instructorService;
	
	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	@GetMapping("/{id}")
	public Instructor getInstructor(@PathVariable Integer id) {
		return instructorService.getInstructor(id);
	}
	
	@GetMapping("/all")
	public List<Instructor> getInstructores(){
		return instructorService.getInstructores();
	}
	
	
	// Escribir 
	@PostMapping
	public Instructor saveInstructor(@RequestBody Instructor instructor) {
		return instructorService.saveInstructor(instructor);
	}
	
	// Borrar
	@DeleteMapping("delete/{id}")
	public void deleteInstructor(@PathVariable Integer id) {
		instructorService.deleteInstructor(id);
	}
	
	// Actualizar
	@PutMapping
	public Instructor updateInstructor(@RequestBody Instructor instructor) {
		return instructorService.updateInstructor(instructor);
	}
}
