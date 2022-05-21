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

import br.com.thulestorecolinas.springbootapp.entity.Cliente;
import br.com.thulestorecolinas.springbootapp.repository.ClienteRepository;
import br.com.thulestorecolinas.springbootapp.service.ClienteService;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ClienteRepository clienteRepo;
    
    @PostMapping(value = "/novo")
    @JsonView(View.ClienteCompleta.class)
    public Cliente cadastrarCliente(@RequestBody ClienteDTO cliente) {
        return clienteService.adicionarCliente(cliente.getNome(),
            cliente.getEmail(),
            cliente.getEstado());
    }
    
    @GetMapping(value = "/busca/{nome}")
    @JsonView(View.ClienteCompleta.class)
    public List<Cliente> buscarPorNome(
    		@PathVariable("nome") String nome) {
    	return clienteRepo.findByNome(nome);
    }

    
}
