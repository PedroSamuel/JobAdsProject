package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import model.AnuncioPlataforma;

@Entity
@NamedQueries({ @NamedQuery(name = "Plataforma.getAll", query = "SELECT s FROM Plataforma s"),
	@NamedQuery(name = "Plataforma.getAllWithAnuncios", query = "SELECT  DISTINCT s FROM Plataforma s LEFT JOIN FETCH s.anuncios") })
public class Plataforma extends Entidade {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "plataforma") //, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			//CascadeType.REFRESH })
	private Set<AnuncioPlataforma> anuncios = new HashSet<AnuncioPlataforma>();
	
	public Set<AnuncioPlataforma> getAnuncios() {
		return anuncios;
	}
	public void setAnuncios(Set<AnuncioPlataforma> anuncios) {
		this.anuncios = anuncios;
	}
	private String nomePlataforma;
	
	private int periodoRenovacao;
	
	private String link;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getNomePlataforma() {
		return nomePlataforma;
	}
	public void setNomePlataforma(String nomePlataforma) {
		this.nomePlataforma = nomePlataforma;
	}
	public int getPeriodoRenovacao() {
		return periodoRenovacao;
	}
	public void setPeriodoRenovacao(int periodoRenovacao) {
		this.periodoRenovacao = periodoRenovacao;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s", nomePlataforma);
	}
	
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof Plataforma) && (id != null) ? id.equals(((Plataforma) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}
	
	/*
	public List<AnuncioPlataforma> getListaAnuncios() {
		return listaAnuncios;
	}
	public void setListaAnuncios(List<AnuncioPlataforma> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}
	*/
	


	
	
	
}
