package br.com.thulestorecolinas.springbootapp.service;

import br.com.thulestorecolinas.springbootapp.entity.Venda;

public interface VendaService {

    public Venda adicionarVenda(String usuario, String cnpj, 
			String uf, String mkt, String grp, float vlr, String dataHora);

    
}