package com.generation.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.demo.model.Instructor;
import com.generation.demo.repository.InstructorRepository;

@Service
public class InstructorServiceImp implements InstructorService{

	InstructorRepository instructorRepository;
	
	public InstructorServiceImp(@Autowired InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}
	
	
	@Override
	public Instructor getInstructor(Integer id) {
		Optional<Instructor> instructor = instructorRepository.findById(id);
		return instructor.orElse(null);
	}

	@Override
	public List<Instructor> getInstructores() {
		return instructorRepository.findAll();
	}

	@Override
	public Instructor saveInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@Override
	public Boolean deleteInstructor(Integer id) {
		try {
			instructorRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

}
