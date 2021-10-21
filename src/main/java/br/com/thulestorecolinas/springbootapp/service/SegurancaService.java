package br.com.thulestorecolinas.springbootapp.service;

import br.com.thulestorecolinas.springbootapp.entity.Usuario;

public interface SegurancaService {

    public Usuario criarUsuario(String nome, String senha, String email, String autorizacao);
    
}