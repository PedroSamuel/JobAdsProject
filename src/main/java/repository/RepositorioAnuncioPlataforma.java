package repository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.AnuncioPlataforma;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;





@Transactional
@ApplicationScoped
public class RepositorioAnuncioPlataforma{
	

	// unitName defined in persistence.xml
	@PersistenceContext(unitName = "database")
	protected EntityManager em;

	protected List<AnuncioPlataforma> localList;

	public void createEntity(AnuncioPlataforma ent) {
		em.persist(ent);
		updateLocalList();
	}

	public List<AnuncioPlataforma> listEntity(Class<AnuncioPlataforma> entClass) {
		return localList;
	}

	public AnuncioPlataforma getEntity(Class<AnuncioPlataforma> entClass, Long id) {
		return em.find(entClass, id);
	}

	public void updateEntity(AnuncioPlataforma ent) {
		em.merge(ent);
		updateLocalList();
	}

	public void removeEntity(AnuncioPlataforma ent) {
		em.remove(em.merge(ent));
	}

	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM AnuncioPlataforma e").getResultList();
	}

	public void updateLocalList() {
		loadFromDB();
	}
}
