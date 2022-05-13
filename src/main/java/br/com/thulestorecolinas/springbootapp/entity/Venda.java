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
	@JoinColumn(name = "cnpj_id")
	@JsonView(View.VendaCompleta.class)
	private String cnpj;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uf_id")
	@JsonView(View.VendaResumo.class)
	private String uf;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mkt_id")
	@JsonView(View.VendaCompleta.class)
	private String mkt;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "grp_id")
	@JsonView(View.VendaResumo.class)
	private String grp;

	@Column(name = "vnd_valor", length = 500, nullable = false)
	@JsonView(View.VendaResumo.class)
	private float vlr;

	@Column(name = "vnd_data_hora", nullable = false)
	@JsonView(View.VendaCompleta.class)
	private Date dataHora;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usr_id")
	@JsonView(View.VendaResumo.class)
	private String usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMkt() {
		return mkt;
	}

	public void setMkt(String mkt) {
		this.mkt = mkt;
	}

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public float getVlr() {
		return vlr;
	}

	public void setVlr(float vlr) {
		this.vlr = vlr;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
}
