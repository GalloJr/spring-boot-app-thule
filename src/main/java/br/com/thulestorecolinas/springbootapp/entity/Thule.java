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
@Table(name="thl_Thule")
public class Thule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "thl_id")
	@JsonView(View.ThuleCompleta.class)
	private Long id;
	
	@Column(name = "thl_titulo", unique=true, length = 100, nullable = false)
	@JsonView(View.ThuleResumo.class)
	private String titulo;
	
	@Column(name = "thl_conteudo", length = 500, nullable = false)
	@JsonView(View.ThuleResumo.class)
	private String conteudo;
	
	@Column(name = "thl_data_hora", nullable = false)
	@JsonView(View.ThuleCompleta.class)
	private Date dataHora;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usr_autor_id")
	@JsonView(View.ThuleCompleta.class)
	private Usuario autor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
}
