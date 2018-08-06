package repository;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

import model.Requerimento;


@RequestScoped
public class RepositorioRequerimentos extends EntityRepository <Requerimento>{

	public List<Requerimento> getAll() {
		return em.createNamedQuery("Requerimento.getAll", Requerimento.class).getResultList();
	}

	public List<Requerimento> porProcessar() {
		return em.createNamedQuery("Requerimento.porProcessar", Requerimento.class).setParameter("estado", "Por Processar").getResultList();
	}

	
	
	
//	private List<Requerimento> porProcessar;
	
//	@SuppressWarnings("unchecked")
//	@PostConstruct
//	protected void loadFromDB() {
//		localList = em.createQuery("SELECT e FROM Requerimento e").getResultList();
//		porProcessar = em.createQuery("SELECT e FROM Requerimento e WHERE e.estado LIKE :estado").setParameter("estado", "Por Processar").getResultList();
//	}
//	
//
//	@Override
//	public void updateLocalList() {
//		loadFromDB();
//	}
//	
//
//	public List<Requerimento> getPorProcessar() {
//		return porProcessar;
//	}
//
//
//	public void setPorProcessar(List<Requerimento> porProcessar) {
//		this.porProcessar = porProcessar;
//	}
//	
	
	

}
