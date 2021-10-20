package br.com.thulestorecolinas.springbootapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aut_id")
	private Long id;
	
	@Column(name = "aut_nome")
	private String nome;
	
	public Long getId() {
		return this.id;
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
}