package br.com.thulestorecolinas.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Produto;
import br.com.thulestorecolinas.springbootapp.repository.ProdutoRepository;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepo;

    @Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Produto adicionarProduto(String nome, String categoria) {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setCategoria(categoria);
		produtoRepo.save(produto);
		
		return produto;
	}
    
}