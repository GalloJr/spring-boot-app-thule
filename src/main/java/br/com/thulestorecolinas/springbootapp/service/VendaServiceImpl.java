package br.com.thulestorecolinas.springbootapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Venda;
import br.com.thulestorecolinas.springbootapp.entity.Cliente;
import br.com.thulestorecolinas.springbootapp.entity.Usuario;
import br.com.thulestorecolinas.springbootapp.repository.VendaRepository;
import br.com.thulestorecolinas.springbootapp.repository.ClienteRepository;
import br.com.thulestorecolinas.springbootapp.repository.UsuarioRepository;

@Service("vendaService")
public class VendaServiceImpl implements VendaService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private VendaRepository vendaRepo;

    @Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Venda adicionarVenda(Integer cliente,Integer filial, Integer produto, Float valor, Date data) {
		Cliente cliente = clienteRepo.findTop1ByNome(cliente);
		if(cliente == null) {
			throw new UsernameNotFoundException(
				"Cliente com identificador " +
				cliente +
				" não foi encontrado");
		}
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setFilial(filial);
		venda.setProduto(produto);
		venda.setValor(valor);
		venda.setData(new Date());
		vendaRepo.save(venda);
		
		return venda;
	}
    
}