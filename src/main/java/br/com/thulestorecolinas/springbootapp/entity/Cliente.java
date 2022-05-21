package br.com.thulestorecolinas.springbootapp.entity;

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
@Table(name="cli_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cli_id")
	@JsonView(View.ClienteCompleta.class)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cli_nome")
	@JsonView(View.ClienteResumo.class)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cli_email")
	@JsonView(View.ClienteResumo.class)
	private String email;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cli_uf")
	@JsonView(View.ClienteCompleta.class)
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
