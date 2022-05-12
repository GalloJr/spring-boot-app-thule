package br.com.thulestorecolinas.springbootapp.service;

import br.com.thulestorecolinas.springbootapp.entity.Thule;

public interface ThuleService {

    public Thule adicionarThule(String titulo, String conteudo, 
			String autor);

    
}