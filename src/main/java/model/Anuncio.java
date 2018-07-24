package model;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import javax.persistence.PreRemove;



@Entity
public class Anuncio extends Entidade {

	private String REF;
	private String funcao;
	private String manager;
	private String estado;
	private String idRequerimento;
	private String requisitos; 
	private Date dataCriacao;
    private Date dataModificacao;
    
    
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "plataforma", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	private Set<AnuncioPlataforma> plataformas = new HashSet<AnuncioPlataforma>();
	
    
    
	public Set<AnuncioPlataforma> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(Set<AnuncioPlataforma> plataformas) {
		this.plataformas = plataformas;
	}

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
	private void preRemove() {
		//implementar
		}

	public String getIdRequerimento() {
		return idRequerimento;
	}

	public void setIdRequerimento(String idRequerimento) {
		this.idRequerimento = idRequerimento;
	}
	
	@Override
	public String toString() {
		return String.format("Anuncio [%s]", REF);
	
	}
	
	public void adicionarPlataforma(Plataforma plataforma) {
		AnuncioPlataforma anunPlat = new AnuncioPlataforma(this, plataforma);
		plataformas.add(anunPlat);
		plataforma.getAnuncios().add(anunPlat);
	}
	
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof Anuncio) && (id != null) ? id.equals(((Anuncio) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}
}
	
	
