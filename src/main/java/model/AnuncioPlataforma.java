package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.PreRemove;





@Entity
@Table(name = "AnuncioPlataforma")
@IdClass(AnuncioPlataforma.class)
public class AnuncioPlataforma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1759734586163651656L;

	private String idHash; 

	@Id
	@ManyToOne
	@JoinColumn(name = "anuncio_id", referencedColumnName = "id")
	private Anuncio anuncio;

	@Id
	@ManyToOne
	@JoinColumn(name = "plataforma_id", referencedColumnName ="id")
	private Plataforma plataforma;
	
	private Date Datacriacao;
	private Date DataModificacao;
	private String Estado; // mudar para enum
	private String link;
	
	
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
	
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	public Plataforma getPlataforma() {
		return plataforma;
	}
	
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	public void setPlataforma(Plataforma plataforma) {
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
	
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof Entidade) && (idHash != null) ? idHash.equals(((Entidade) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (idHash != null) ? (this.getClass().hashCode() + idHash.hashCode()) : super.hashCode();
	}

	@Override
	public String toString() {
		return String.format("ExampleEntity[%d]", idHash);
	}


	public String getIdHash() {
		return idHash;
	}


	public void setIdHash() {
		if ((anuncio != null) && (plataforma != null)) {
			this.idHash = ("A" + anuncio.id + "P" + plataforma.id); 
		} else {
			this.idHash = "ERRO";
		}
	}

	
}
