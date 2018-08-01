 package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.Entidade;;

@Transactional
public abstract class EntityRepository<T extends Entidade> {

	// unitName defined in persistence.xml
	@PersistenceContext(unitName = "database")
	protected EntityManager em;

	protected List<T> localList;

	public void createEntity(T ent) {
		em.persist(ent);
		updateLocalList();
	}

	public List<T> listEntity(Class<T> entClass) {
		return localList;
	}

	public T getEntity(Class<T> entClass, Long id) {
		return em.find(entClass, id);
	}

	public void updateEntity(T ent) {
		em.merge(ent);
		updateLocalList();
	}

	public void removeEntity(T ent) {
		em.remove(em.merge(ent));
	}

	
	//metodo que insere 
	public abstract void updateLocalList();

}
