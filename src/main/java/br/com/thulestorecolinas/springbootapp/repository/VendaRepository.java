package br.com.thulestorecolinas.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import br.com.thulestorecolinas.springbootapp.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	@PreAuthorize("isAuthenticated()")
    public List<Venda> findByNomeUsuario(String nome);

}
