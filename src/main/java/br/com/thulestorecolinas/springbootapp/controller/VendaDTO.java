package br.com.thulestorecolinas.springbootapp.controller;

import java.sql.Date;

public class VendaDTO {
    
    private Integer cliente;
    private Integer filial;
    private Integer produto;
	private Float valor;
	private Date data;
	
	public Integer getCliente() {
		return cliente;
	}
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	public Integer getFilial() {
		return filial;
	}
	public void setFilial(Integer filial) {
		this.filial = filial;
	}
	public Integer getProduto() {
		return produto;
	}
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	

}
