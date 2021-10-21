package br.com.thulestorecolinas.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thulestorecolinas.springbootapp.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{
    
    public Autorizacao findByNome(String autorizacao);
    
}