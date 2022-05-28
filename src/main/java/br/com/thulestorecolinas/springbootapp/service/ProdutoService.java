package br.com.thulestorecolinas.springbootapp.service;

import br.com.thulestorecolinas.springbootapp.entity.Produto;

public interface ProdutoService {

    public Produto adicionarProduto(String nome, String categoria);

    
}