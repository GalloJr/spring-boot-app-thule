package br.com.thulestorecolinas.springbootapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Venda;
import br.com.thulestorecolinas.springbootapp.repository.VendaRepository;

@Service("vendaService")
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepo;

    @Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Venda adicionarVenda(Integer cliente, Integer produto, Float valor, Date data) {
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setProduto(produto);
		venda.setValor(valor);
		venda.setData(new Date());
		vendaRepo.save(venda);
		
		return venda;
	}
    
}