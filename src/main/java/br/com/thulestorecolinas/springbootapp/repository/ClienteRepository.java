package br.com.thulestorecolinas.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import br.com.thulestorecolinas.springbootapp.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@PreAuthorize("isAuthenticated()")
    public List<Cliente> findByNome(String nome);

    public Cliente findTop1ByNome(Cliente cliente);

    public Cliente findById(Cliente cliente);

}
