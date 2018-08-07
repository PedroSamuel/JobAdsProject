package repository;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.Requerimento;


@ApplicationScoped
public class RepositorioRequerimentos extends EntityRepository <Requerimento>{
	
	private List<Requerimento> porProcessar;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM Requerimento e").getResultList();
		porProcessar = em.createQuery("SELECT e FROM Requerimento e WHERE e.estado LIKE :estado").setParameter("estado", "Por Processar").getResultList();
	}
	

	@Override
	public void updateLocalList() {
		loadFromDB();
	}
	

	public List<Requerimento> getPorProcessar() {
		return porProcessar;
	}


	public void setPorProcessar(List<Requerimento> porProcessar) {
		this.porProcessar = porProcessar;
	}
	
	
	

}
