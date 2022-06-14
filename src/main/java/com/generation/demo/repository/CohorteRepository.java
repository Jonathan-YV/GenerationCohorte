package com.generation.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation.demo.model.Cohorte;

@Repository
public interface CohorteRepository extends JpaRepository<Cohorte,Integer>{
	
	Cohorte findByNumeroCohorte(Integer numeroCohorte);
	
	List<Cohorte> findByCiudad(String ciudad);
	
	@Query(value = "SELECT id_instructor as id, instructor.nombre as nombreInstructor, alumno.nombre as nombreAlumno FROM instructor inner join alumno on instructor.cohorte_id = alumno.cohorte_id;", nativeQuery = true)
	List<Map<String,Object>> obtenerInstructoresAlumnos();
	
}
