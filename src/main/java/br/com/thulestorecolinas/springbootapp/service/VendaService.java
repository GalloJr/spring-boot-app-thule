package br.com.thulestorecolinas.springbootapp.service;

import java.util.Date;

import br.com.thulestorecolinas.springbootapp.entity.Venda;

public interface VendaService {

    public Venda adicionarVenda(Integer cliente,Integer filial, Integer produto, Float valor, Date data);

    
}