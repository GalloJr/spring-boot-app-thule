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

import br.com.thulestorecolinas.springbootapp.entity.Thule;
import br.com.thulestorecolinas.springbootapp.repository.ThuleRepository;
import br.com.thulestorecolinas.springbootapp.service.ThuleService;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/thule")
@CrossOrigin
public class ThuleController {

    @Autowired
    private ThuleService thuleService;
    
    @Autowired
    private ThuleRepository thuleRepo;
    
    @PostMapping(value = "/nova")
    @JsonView(View.ThuleCompleta.class)
    public Thule cadastrarThule(@RequestBody ThuleDTO thule) {
        return thuleService.adicionarThule(thule.getTitulo(), 
                thule.getConteudo(),
                thule.getUsuario());
    }
    
    @GetMapping(value = "/busca/{nome}")
    @JsonView(View.ThuleCompleta.class)
    public List<Thule> buscarPorTitulo(
    		@PathVariable("nome") String nome) {
    	return thuleRepo.findByNome(nome);
    }

    
}
