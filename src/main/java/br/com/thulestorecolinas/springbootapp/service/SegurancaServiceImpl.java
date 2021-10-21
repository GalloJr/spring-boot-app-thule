package br.com.thulestorecolinas.springbootapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Autorizacao;
import br.com.thulestorecolinas.springbootapp.entity.Usuario;
import br.com.thulestorecolinas.springbootapp.repository.AutorizacaoRepository;
import br.com.thulestorecolinas.springbootapp.repository.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private AutorizacaoRepository autRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Transactional
    public Usuario criarUsuario(String nome, String senha, String email, String autorizacao) {
        Autorizacao aut = autRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autRepo.save(aut);
        }
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isPresent()) {
            return usuarioOp.get();
        }
        throw new RuntimeException("Usuário não encontrado!");
    }

    @Override
    public Usuario buscarUsuarioPorNome(String nome) {
        Usuario usuario = usuarioRepo.findByNome(nome);
        if(usuario != null) {
            return usuario;
        }
        throw new RuntimeException("Usuário não encontrado!");
    }
    
}