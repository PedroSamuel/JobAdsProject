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
public class Anuncio extends Entidade {

	private static final long serialVersionUID = 1L;
	@Column(name = "Referencia")
	private String REF;
	@Column(name = "Funçao")
	private String funcao;
	@Column(name = "Manager")
	private String manager;
	
	@Column(name = "Estado")
	private String estado; //posteriormente mudar para enum 
	
	@Column(name = "Requisitos")
	private String requisitos; 
	
	@Column(name = "DataCriaçao")
	private Date dataCriacao;
	@Column(name = "UltimaModificacao")
    private Date dataModificacao;
	
    
    
	public String getREF() {
		return REF;
	}
	
	public void setREF(String rEF) {
		REF = rEF;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getManager() {
	 	return manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getRequisitos() {
		return requisitos;
	}
	
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Date getDataModificacao() {
		return dataModificacao;
	}
	
	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
    
	@PreRemove
	public void preRemove() {
		//implementar
		}
}
	
	
