package model;


import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;


@Entity
public class Requerimento extends Entidade {
	
	private static final long serialVersionUID = 1L;
	
	private String requerente;
	private String data;
	private String email;
	private String funcao;
	private String requisitos;
	private String notas;	
	private String estado;
	
	

	
	public String getRequerente() {
		return requerente;
	}

	
	public void setRequerente(String requerente) {
		this.requerente = requerente;
	}

	
	public String getData() {
		return data;
	}

	
	public void setData(String data) {
		this.data = data;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getFuncao() {
		return funcao;
	}

	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
	public String getRequisitos() {
		return requisitos;
	}

	
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	
	public String getNotas() {
		return notas;
	}

	
	public void setNotas(String notas) {
		this.notas = notas;
	}

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
