package br.com.thulestorecolinas.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thulestorecolinas.springbootapp.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}