package repository;

import javax.annotation.PostConstruct;

import model.AnuncioPlataforma;

public class RepositorioAnuncioPlataforma extends EntityRepository<AnuncioPlataforma> {
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM AnuncioPlataforma e").getResultList();
	}

	@Override
	public void updateLocalList() {
		loadFromDB();
	}

}
