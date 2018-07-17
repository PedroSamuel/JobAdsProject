package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.AnuncioPlataforma;

@Entity
public class Plataforma extends Entidade {
	private static final long serialVersionUID = 1L;
	
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
