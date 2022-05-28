package br.com.thulestorecolinas.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import br.com.thulestorecolinas.springbootapp.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@PreAuthorize("isAuthenticated()")
    public List<Produto> findByNome(String nome);

    public Produto findTop1ByNome(Produto produto);

    public Produto findById(Produto produto);

}
