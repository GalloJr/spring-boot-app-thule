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

import br.com.thulestorecolinas.springbootapp.entity.Venda;
import br.com.thulestorecolinas.springbootapp.repository.VendaRepository;
import br.com.thulestorecolinas.springbootapp.service.VendaService;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/venda")
@CrossOrigin
public class VendaController {

    @Autowired
    private VendaService vendaService;
    
    @Autowired
    private VendaRepository vendaRepo;
    
    @PostMapping(value = "/nova")
    @JsonView(View.VendaCompleta.class)
    public Venda cadastrarVenda(@RequestBody VendaDTO venda) {
        return vendaService.adicionarVenda(venda.getUsuario(), 
            venda.getCNPJ(),
            venda.getUF(),
            venda.getMKT(),
            venda.getGRP(),
            venda.getVlr(),
            venda.getDataHora());
    }
    
    @GetMapping(value = "/busca/{nome}")
    @JsonView(View.VendaCompleta.class)
    public List<Venda> buscarPorNome(
    		@PathVariable("nome") String nome) {
    	return vendaRepo.findByNome(nome);
    }

    
}
