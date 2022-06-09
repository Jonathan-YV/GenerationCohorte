package com.generation.demo.service;

import java.util.List;
import java.util.Map;

import com.generation.demo.model.Cohorte;

public interface CohorteService {

	//Definir los metodos que vamos a utilizar
	
	// Leer
	Cohorte getCohorte(Integer id);
	List<Cohorte> getCohortes();
	List<Cohorte> getCohortesByCiudad(String ciudad);
	List<Map<String,Object>> getInstructoresAlumnos();
	
	//Guardar
	Cohorte saveCohorte(Cohorte cohorte);
	
	
	//Borrar
	Boolean deleteCohorte(Integer id);
	
	//Actualizar
	Cohorte updateClase(Cohorte cohorte);
	
}
