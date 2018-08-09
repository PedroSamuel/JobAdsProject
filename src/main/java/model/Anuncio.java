package model;




import java.time.*;
import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import javax.persistence.PreRemove;




@Entity
@NamedQueries({ @NamedQuery(name = "Anuncio.getAll", query = "SELECT e FROM Anuncio e"),
	@NamedQuery(name = "Anuncio.getAllWithPlataformas", query = "SELECT DISTINCT e FROM Anuncio e LEFT JOIN FETCH e.plataformas"),
	@NamedQuery(name = "Anuncio.getWithPlataformasById", query = "SELECT e FROM Anuncio e LEFT JOIN FETCH e.plataformas WHERE e.id LIKE :id"),
	@NamedQuery(name = "Anuncio.countAll", query = "SELECT COUNT(e.id) FROM Anuncio e"),
	@NamedQuery(name = "Anuncio.comTarefa", query = "SELECT DISTINCT e FROM Anuncio e LEFT JOIN FETCH e.plataformas WHERE e.tarefas LIKE :tarefas"),
	@NamedQuery(name = "Anuncio.getAnunciosAplicar", query = "SELECT DISTINCT e FROM Anuncio e LEFT JOIN FETCH e.plataformas WHERE e.estado LIKE :estado")})




public class Anuncio extends Entidade {

	private String REF;
	private String funcao;
	private String manager;
	private String estado;
	private String idRequerimento;
	@Lob
	private String requisitos; 
	private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private String tarefas;
    private String descriçaoTarefas;
    
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "anuncio") //,cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			//CascadeType.REFRESH })
	private Set<AnuncioPlataforma> plataformas = new HashSet<AnuncioPlataforma>();
	
    
    
	public Set<AnuncioPlataforma> getPlataformas() {
		return plataformas;
	}
	
	public int countPlataformas() {
		return plataformas.size();
	}
	public long countPlataformasOnline() {
		return plataformas.stream().filter( p -> p.getEstado().equals("Online") ).count();//.collect(Collectors.toList()).size()
	}

	public void setPlataformas(Set<AnuncioPlataforma> plataformas) {
		this.plataformas = plataformas;
	}

	public String getREF() {
		return REF;
	}
	
	public void setREF(String rEF) {
		REF = rEF;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getManager() {
	 	return manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getRequisitos() {
		return requisitos;
	}
	
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public LocalDateTime getDataModificacao() {
		return dataModificacao;
	}
	
	public void setDataModificacao(LocalDateTime dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
    
	@PreRemove
	private void preRemove() {
		//implementar
		}

	public String getIdRequerimento() {
		return idRequerimento;
	}

	public void setIdRequerimento(String idRequerimento) {
		this.idRequerimento = idRequerimento;
	}
	
	@Override
	public String toString() {
		return String.format("Anuncio [%s]", REF);
	
	}
	
	public void adicionarPlataforma(Plataforma plataforma) {
		AnuncioPlataforma anunPlat = new AnuncioPlataforma(this, plataforma);
		plataformas.add(anunPlat);
		plataforma.getAnuncios().add(anunPlat);
	}
	
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof Anuncio) && (id != null) ? id.equals(((Anuncio) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}

	public String getTarefas() {
		return tarefas;
	}

	
	public void temTarefa() {
		tarefas = "Tem Tarefas";
	}
	
	public void feito() {
		tarefas = "Feito";
	}

	public void removerPlataforma(AnuncioPlataforma anuncioplataforma) {
		plataformas.remove(anuncioplataforma);
		
	}

	public String getDescriçaoTarefas() {
		return descriçaoTarefas;
	}

	public void setDescriçaoTarefas(String descriçaoTarefas) {
		this.descriçaoTarefas = descriçaoTarefas;
	}
	
	
	

}
	
	
