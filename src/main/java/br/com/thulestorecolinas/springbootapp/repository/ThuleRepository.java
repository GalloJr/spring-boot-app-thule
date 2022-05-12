package br.com.thulestorecolinas.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import br.com.thulestorecolinas.springbootapp.entity.Thule;

public interface ThuleRepository extends JpaRepository<Thule, Long>{
	
	@PreAuthorize("isAuthenticated()")
    public List<Thule> findByNome(String nome);

}
