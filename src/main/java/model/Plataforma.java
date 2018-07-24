package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import model.AnuncioPlataforma;

@Entity
public class Plataforma extends Entidade {
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "anuncio", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<AnuncioPlataforma> anuncios = new ArrayList<AnuncioPlataforma>();
	
	public List<AnuncioPlataforma> getAnuncios() {
		return anuncios;
	}
	public void setAnuncios(List<AnuncioPlataforma> anuncios) {
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
	
	/*
	public List<AnuncioPlataforma> getListaAnuncios() {
		return listaAnuncios;
	}
	public void setListaAnuncios(List<AnuncioPlataforma> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}
	*/
	


	
	
	
}
