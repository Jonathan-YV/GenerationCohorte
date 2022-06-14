package com.generation.demo.service;

import java.util.List;

import com.generation.demo.model.Usuario;

public interface UsuarioService {
	
	Usuario getUsuario(Integer id);
	List<Usuario> getUsuarios();
	
	Usuario saveUsuario(Usuario usuario);
}
