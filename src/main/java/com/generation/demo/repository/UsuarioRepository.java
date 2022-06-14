package com.generation.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.demo.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	Usuario findByCorreo(String correo);
}
