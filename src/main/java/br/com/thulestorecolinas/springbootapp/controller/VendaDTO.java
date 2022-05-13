package br.com.thulestorecolinas.springbootapp.controller;

public class VendaDTO {
    
    private String usuario;
    private String cnpj;
    private String uf;
	private String mkt;
	private String grp;
	private String vlr;
	private String dthr;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getVlr() {
		return vlr;
	}

	public void setVlr(String vlr) {
		this.vlr = vlr;
	}

	public String getDthr() {
		return dthr;
	}

	public void setDthr(String dthr) {
		this.dthr = dthr;
	}

	

}
