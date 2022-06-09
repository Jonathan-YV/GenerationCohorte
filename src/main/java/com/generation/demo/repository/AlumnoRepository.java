package com.generation.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.demo.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer>{

}
