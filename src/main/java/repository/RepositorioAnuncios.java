
package repository;

import java.util.Collection;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.Anuncio;

@ApplicationScoped
public class RepositorioAnuncios extends EntityRepository<Anuncio> {
	
	private Collection<Anuncio> comTarefa;

	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM Anuncio e").getResultList();
	}
	
	

	@Override
	public void updateLocalList() {
		loadFromDB();
	}

	@SuppressWarnings("unchecked")
	public Collection<Anuncio> comTarefa() {
		setComTarefa(em.createQuery("SELECT e FROM Anuncio e WHERE e.tarefas LIKE :tarefas").setParameter("estado", "!!!!").getResultList());
		return comTarefa;
	}



	public Collection<Anuncio> getComTarefa() {
		return comTarefa;
	}



	public void setComTarefa(Collection<Anuncio> comTarefa) {
		this.comTarefa = comTarefa;
	}
}