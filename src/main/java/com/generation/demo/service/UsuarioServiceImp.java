package com.generation.demo.service;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.demo.model.Usuario;
import com.generation.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService, UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImp(@Autowired UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public Usuario getUsuario(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		 Usuario user = usuarioRepository.findByCorreo(correo);

	        if(user == null) {
	            throw new UsernameNotFoundException(correo);
	        }
	        return new org.springframework.security.core.userdetails.User(user.getCorreo(), user.getPassword(), emptyList());
	}

}
