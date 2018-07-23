package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import model.AnuncioPlataforma;

@Entity
public class Plataforma extends Entidade {
	
	@OneToMany(mappedBy = "anuncio")
	private List<AnuncioPlataforma> anuncios = new ArrayList<AnuncioPlataforma>();
	
	public List<AnuncioPlataforma> getAnuncios() {
		return anuncios;
	}
	public void setAnuncios(List<AnuncioPlataforma> anuncios) {
		this.anuncios = anuncios;
	}
	String nomePlataforma;
	int periodoRenovacao;
	// List <AnuncioPlataforma> listaAnuncios;
	
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
	
	/*
	public List<AnuncioPlataforma> getListaAnuncios() {
		return listaAnuncios;
	}
	public void setListaAnuncios(List<AnuncioPlataforma> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}
	*/
	


	
	
	
}
