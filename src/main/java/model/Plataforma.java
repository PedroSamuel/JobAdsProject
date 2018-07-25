package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import model.AnuncioPlataforma;

@Entity
public class Plataforma extends Entidade {
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "anuncio", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	private Set<AnuncioPlataforma> anuncios = new HashSet<AnuncioPlataforma>();
	
	public Set<AnuncioPlataforma> getAnuncios() {
		return anuncios;
	}
	public void setAnuncios(Set<AnuncioPlataforma> anuncios) {
		this.anuncios = anuncios;
	}
	String nomePlataforma;
	
	int periodoRenovacao;
	
	
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
		return String.format("[%s]", nomePlataforma);
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
