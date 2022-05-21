package br.com.thulestorecolinas.springbootapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.thulestorecolinas.springbootapp.controller.View;

@Entity
@Table(name="vnd_venda")
public class Venda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "vnd_id")
	@JsonView(View.VendaCompleta.class)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cli_id")
	@JsonView(View.VendaCompleta.class)
	private Integer cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fl_id")
	@JsonView(View.VendaResumo.class)
	private Integer filial;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prd_id")
	@JsonView(View.VendaCompleta.class)
	private Integer produto;

	@Column(name = "vnd_valor", length = 500, nullable = false)
	@JsonView(View.VendaResumo.class)
	private float valor;

	@Column(name = "vnd_data", nullable = false)
	@JsonView(View.VendaCompleta.class)
	private Date data;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public long getCliente() {
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
	
}
