package model;



import java.time.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({ @NamedQuery(name = "Requerimento.getAll", query = "SELECT e FROM Requerimento e"),
	@NamedQuery(name = "Requerimento.porProcessar", query = "SELECT e FROM Requerimento e WHERE e.estado LIKE :estado") })
public class Requerimento extends Entidade {
	

	
	private String requerente;
	private LocalDateTime data;
	private String email;
	private String funcao;
	@Lob
	private String requisitos;
	private String notas;	
	private String estado = "Por Processar";
	
	

	
	public String getRequerente() {
		return requerente;
	}

	
	public void setRequerente(String requerente) {
		this.requerente = requerente;
	}

	
	public LocalDateTime getData() {
		return data;
	}

	
	public void setData(LocalDateTime data) {
		this.data = data;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getFuncao() {
		return funcao;
	}

	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
	public String getRequisitos() {
		return requisitos;
	}

	
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	
	public String getNotas() {
		return notas;
	}

	
	public void setNotas(String notas) {
		this.notas = notas;
	}

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	


	public void processar() {
		setEstado("Processado");
		
	}
	
	
	
	
	

}
