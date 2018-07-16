package model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.PreRemove;




@Entity
@Table(name= "AnuncioPlataforma")
public class AnuncioPlataforma extends Entidade{
	private static final long serialVersionUID = 1L;

	/*@ManyToOne
	Anuncio anuncio;
	*/
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	@Column(name="Plataforma")
	String plataforma;
	@Column(name="DataCriacao")
	Date Datacriacao;
	@Column(name="DataModificacao")
	Date DataModificacao;
	@Column(name="Estado")
	String Estado; // mudar para enum
	@Column(name="Link")
	String link;
	
	/*
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	*/
	
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	public String getPlataforma() {
		return plataforma;
	}
	
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	/*
	public Anuncio getAnuncio() {
		return anuncio;
	}
	*/
	
	public Date getDatacriacao() {
		return Datacriacao;
	}
	public void setDatacriacao(Date datacriacao) {
		Datacriacao = datacriacao;
	}
	public Date getDataModificacao() {
		return DataModificacao;
	}
	public void setDataModificacao(Date dataModificacao) {
		DataModificacao = dataModificacao;
	}
	
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@PreRemove
	public void preRemove() {
		//implementar
		}
	
}
