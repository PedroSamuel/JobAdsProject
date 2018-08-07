package repository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.Plataforma;

@ApplicationScoped
public class RepositorioPlataformas extends EntityRepository<Plataforma> {
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM Plataforma e").getResultList();
	}

	@Override
	public void updateLocalList() {
		loadFromDB();
	}

}
