package br.com.thulestorecolinas.springbootapp.service;

import br.com.thulestorecolinas.springbootapp.entity.Cliente;

public interface ClienteService {

    public Cliente adicionarCliente(String nome, String email, String estado);

    
}