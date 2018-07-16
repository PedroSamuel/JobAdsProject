package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.PreRemove;
import javax.persistence.Table;




@Entity
@Table(name= "Anúncio - Plataforma")
public class AnuncioPlataforma extends Entidade{
	Anuncio anuncio;
	
	//mudar depois para objecto plataforma neste atributo Plataforma plataforma
	String plataforma;
	Date Datacriacao;
	Date DataModificacao;
	String Estado; // mudar para enum
	String link;
	
	
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
	
	
}
