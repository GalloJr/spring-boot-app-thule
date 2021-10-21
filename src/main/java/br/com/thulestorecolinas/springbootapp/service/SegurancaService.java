package br.com.thulestorecolinas.springbootapp.service;

import java.util.List;

import br.com.thulestorecolinas.springbootapp.entity.Usuario;

public interface SegurancaService {

    public Usuario criarUsuario(String nome, String senha, String email, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);
    
}