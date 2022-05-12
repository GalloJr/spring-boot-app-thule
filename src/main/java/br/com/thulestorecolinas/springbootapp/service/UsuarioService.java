package br.com.thulestorecolinas.springbootapp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.thulestorecolinas.springbootapp.entity.Usuario;

public interface UsuarioService extends UserDetailsService {
	
	public Usuario novoUsuario(String nome, String email, 
			String senha, String autorizacao);

	public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);
    
    public Usuario buscarUsuarioPorNome(String nome);

}
