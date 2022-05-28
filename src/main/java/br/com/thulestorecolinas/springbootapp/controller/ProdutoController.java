package br.com.thulestorecolinas.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thulestorecolinas.springbootapp.entity.Produto;
import br.com.thulestorecolinas.springbootapp.repository.ProdutoRepository;
import br.com.thulestorecolinas.springbootapp.service.ProdutoService;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ProdutoRepository produtoRepo;
    
    @PostMapping(value = "/novo")
    @JsonView(View.ProdutoCompleta.class)
    public Produto cadastrarProduto(@RequestBody ProdutoDTO produto) {
        return produtoService.adicionarProduto(produto.getNome(),
            produto.getCategoria());
    }
    
    @GetMapping(value = "/busca/{nome}")
    @JsonView(View.ProdutoCompleta.class)
    public List<Produto> buscarPorNome(
    		@PathVariable("nome") String nome) {
    	return produtoRepo.findByNome(nome);
    }

    
}
