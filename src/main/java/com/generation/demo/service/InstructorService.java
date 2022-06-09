package com.generation.demo.service;

import java.util.List;

import com.generation.demo.model.Instructor;

public interface InstructorService {

	Instructor getInstructor(Integer id);
	List<Instructor> getInstructores();
	
	Instructor saveInstructor(Instructor instructor);
	
	Boolean deleteInstructor(Integer id);
	
	Instructor updateInstructor(Instructor instructor);
}
