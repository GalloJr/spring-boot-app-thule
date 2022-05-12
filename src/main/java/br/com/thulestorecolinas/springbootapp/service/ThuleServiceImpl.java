package br.com.thulestorecolinas.springbootapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Thule;
import br.com.thulestorecolinas.springbootapp.entity.Usuario;
import br.com.thulestorecolinas.springbootapp.repository.ThuleRepository;
import br.com.thulestorecolinas.springbootapp.repository.UsuarioRepository;

@Service("thuleService")
public class ThuleServiceImpl implements ThuleService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private ThuleRepository thuleRepo;

    @Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Thule adicionarThule(String titulo, String conteudo, String autor) {
		Usuario usuario = usuarioRepo.findTop1ByNomeOrEmail(
				autor, autor);
		if(usuario == null) {
			throw new UsernameNotFoundException(
				"Usuário com identificador " +
				autor +
				" não foi encontrado");
		}
		Thule thule = new Thule();
		thule.setTitulo(titulo);
		thule.setConteudo(conteudo);
		thule.setAutor(usuario);
		thule.setDataHora(new Date());
		thuleRepo.save(thule);
		
		return thule;
	}
    
}