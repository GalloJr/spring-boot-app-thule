package br.com.thulestorecolinas.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Cliente;
import br.com.thulestorecolinas.springbootapp.repository.ClienteRepository;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Cliente adicionarCliente(String nome, String email, String estado) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setEstado(estado);
		clienteRepo.save(cliente);
		
		return cliente;
	}
    
}