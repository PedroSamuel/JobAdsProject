package model;

import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.PreRemove;





@Entity
public class AnuncioPlataforma extends Entidade{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Anuncio anuncio;
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	private String plataforma;
	private Date Datacriacao;
	private Date DataModificacao;
	private String Estado; // mudar para enum
	private String link;
	
	
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
	
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	public String getPlataforma() {
		return plataforma;
	}
	
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	
	public Anuncio getAnuncio() {
		return anuncio;
	}

	
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
