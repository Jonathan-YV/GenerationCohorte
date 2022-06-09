package com.generation.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.demo.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
