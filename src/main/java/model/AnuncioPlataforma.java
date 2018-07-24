package model;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.PreRemove;





@Entity
@Table(name = "anuncioplataforma")
public class AnuncioPlataforma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1759734586163651656L;
	


	@EmbeddedId
	private AnuncioPlataformaId id;

	public AnuncioPlataformaId getId() {
		return id;
	}
	
	
	//private String isbn;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("anuncio_id")
	@JoinColumn(name = "ANUNCIO_ID")
	private Anuncio anuncio;


	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("plataforma_id")
	@JoinColumn(name = "PLATAFORMA_ID")
	private Plataforma plataforma;
	
	private Date Datacriacao;
	private Date DataModificacao;
	private String Estado; // mudar para enum
	private String link;
	
	
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
	
	
	public Plataforma getPlataforma() {
		return plataforma;
	}
	

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
	private void preRemove() {
		this.anuncio.getPlataformas().remove(this);
	}
	
	


	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}

	@Override
	public String toString() {
		return String.format("AnuncioPlataforma[%s]", id);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioPlataforma)) return false;
        AnuncioPlataforma anuncioPlataforma = (AnuncioPlataforma) o;
        return Objects.equals(getId(), anuncioPlataforma.getId());
    }

//	public String getIdHash() {
//		return idHash;
//	}
//
//	@PostConstruct
//	private void setIdHash() {
//		if ((anuncio != null) && (plataforma != null)) {
//			this.idHash = ("A" + anuncio.id + "P" + plataforma.id); 
//		} else {
//			this.idHash = "ERRO";
//		}
//	}


//
//	public String getIsbn() {
//		return isbn;
//	}
////
////
//
//public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}

	
}
