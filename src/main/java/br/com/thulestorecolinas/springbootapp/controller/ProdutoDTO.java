package br.com.thulestorecolinas.springbootapp.controller;

public class ProdutoDTO {
    
    private String nome;
    private String categoria;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
	
}
