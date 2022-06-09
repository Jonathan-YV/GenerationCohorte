package com.generation.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.demo.model.Alumno;
import com.generation.demo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService{

	AlumnoRepository alumnoRepository;
	
	public AlumnoServiceImp(@Autowired AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}
	
	@Override
	public Alumno getAlumno(Integer id) {
		Optional<Alumno> alumno = alumnoRepository.findById(id);
		return alumno.orElse(null);
	}

	@Override
	public List<Alumno> getAlumnos() {
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno saveAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public Boolean deleteAlumno(Integer id) {
		try {
			alumnoRepository.deleteById(id);
			return true;
		}catch(Exception err){
			return false;
		}
		
	}

	@Override
	public Alumno updateAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

}
