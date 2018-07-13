package model;


import java.util.Date;

public class Anuncio {

	private String REF;
	private String funcao;
	private String manager;
	
	
	private String estado; //posteriormente mudar para enum 
	
	private String requisitos; 
	
	private Date dataCriacao;
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
	
    
    
	
	
}