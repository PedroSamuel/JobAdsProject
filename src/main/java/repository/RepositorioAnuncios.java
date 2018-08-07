
package repository;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.enterprise.context.RequestScoped;

import model.Anuncio;

@RequestScoped
public class RepositorioAnuncios extends EntityRepository<Anuncio> {
	
	
	public List<Anuncio> getAll() {
		return em.createNamedQuery("Anuncio.getAll", Anuncio.class).getResultList();
	}

	public List<Anuncio> getAllWithPlataformas() {
		return em.createNamedQuery("Anuncio.getAllWithPlataformas", Anuncio.class).getResultList();
	}
	
	public List<Anuncio> comTarefa() {
		return em.createNamedQuery("Anuncio.comTarefa", Anuncio.class).setParameter("tarefas", "!!!!").getResultList();
	}

	

}
	
	
//	private Collection<Anuncio> comTarefa;
//
//	@SuppressWarnings("unchecked")
//	@PostConstruct
//	protected void loadFromDB() {
//		localList = em.createQuery("SELECT e FROM Anuncio e").getResultList();
//	}
//	
//	
//
//	@Override
//	public void updateLocalList() {
//		loadFromDB();
//	}
//
//	@SuppressWarnings("unchecked")
//	public Collection<Anuncio> comTarefa() {
//		setComTarefa(em.createQuery("SELECT e FROM Anuncio e WHERE e.tarefas LIKE :tarefas").setParameter("tarefas", "!!!!").getResultList());
//		return comTarefa;
//	}
//
//
//
//	public Collection<Anuncio> getComTarefa() {
//		return comTarefa;
//	}
//
//
//
//	public void setComTarefa(Collection<Anuncio> comTarefa) {
//		this.comTarefa = comTarefa;
//	}
//}