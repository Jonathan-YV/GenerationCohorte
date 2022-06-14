package com.generation.demo.controller;

import com.generation.demo.model.Usuario;
import com.generation.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuarioController(@Autowired BCryptPasswordEncoder bCryptPasswordEncoder, @Autowired UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
	}
	
	@PostMapping
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		return usuarioService.saveUsuario(usuario);
	}
	
	@GetMapping("/{id}")
	public Usuario getUsuario(@PathVariable Integer id) {
		return usuarioService.getUsuario(id);
	}
	
	@GetMapping("/all")
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	
	
}
