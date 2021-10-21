package br.com.thulestorecolinas.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.thulestorecolinas.springbootapp.entity.Usuario;
import br.com.thulestorecolinas.springbootapp.service.SegurancaService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private SegurancaService segurancaService;
    
    @GetMapping
    public List<Usuario> buscarTodos() {
        return segurancaService.buscarTodosUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id) {
        return segurancaService.buscarUsuarioPorId(id);
    }

    @GetMapping(value = "/nome")
    public Usuario buscarPorNome(@RequestParam(value="nome") String nome) {
        return segurancaService.buscarUsuarioPorNome(nome);
    }

    @PostMapping
    public Usuario cadastrarNovoUsuario(@RequestBody Usuario usuario) {
        return segurancaService.criarUsuario(usuario.getNome(), usuario.getSenha(), usuario.getEmail(), "ROLE_USUARIO");
    }
}
