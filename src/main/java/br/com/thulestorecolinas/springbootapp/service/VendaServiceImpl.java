package br.com.thulestorecolinas.springbootapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Venda;
import br.com.thulestorecolinas.springbootapp.entity.Usuario;
import br.com.thulestorecolinas.springbootapp.repository.VendaRepository;
import br.com.thulestorecolinas.springbootapp.repository.UsuarioRepository;

@Service("vendaService")
public class VendaServiceImpl implements VendaService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private VendaRepository vendaRepo;

    @Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Venda adicionarVenda(String nome, String cnpj, String uf, String mkt, String grp, Float vlr, String dataHora) {
		Usuario usuario = usuarioRepo.findTop1ByNome(nome);
		if(usuario == null) {
			throw new UsernameNotFoundException(
				"Usuário com identificador " +
				nome +
				" não foi encontrado");
		}
		Venda venda = new Venda();
		venda.setUsuario(nome);
		venda.setCnpj(cnpj);
		venda.setUf(uf);
		venda.setMkt(mkt);
		venda.setGrp(grp);
		venda.setVlr(vlr);
		venda.setDataHora(new Date());
		vendaRepo.save(venda);
		
		return venda;
	}
    
}