package repository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.Anuncio;
import model.AnuncioPlataforma;
import model.Plataforma;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.enterprise.context.RequestScoped;





@Transactional
@RequestScoped
public class RepositorioAnuncioPlataforma{
	
	@PersistenceContext(unitName = "database")
	protected EntityManager em;

	public void createEntity(AnuncioPlataforma ent) {
		em.persist(ent);
	}

	public void removeEntity(AnuncioPlataforma ent) {
		em.remove(em.merge(ent));
	}

	public void updateEntity(AnuncioPlataforma ent) {
		em.merge(ent);
	}
	
	
	public List<AnuncioPlataforma> getAll() {
		return em.createNamedQuery("AnuncioPlataforma.getAll", AnuncioPlataforma.class).getResultList();
	}

	
	public AnuncioPlataforma getEntity(Class<AnuncioPlataforma> entClass, Long id) {
	return em.find(entClass, id);
	}
	
	public List<AnuncioPlataforma> getEverything() {
		return em.createNamedQuery("AnuncioPlataforma.getEverything", AnuncioPlataforma.class).getResultList();
	}

	public List<AnuncioPlataforma> selectAnunPlat(long idAnuncio) {
		return em.createNamedQuery("AnuncioPlataforma.getAllWithAnunciosAndPlataformas", AnuncioPlataforma.class).setParameter("idAnuncio", "idAnuncior").getResultList();
	}
	

	// unitName defined in persistence.xml
//	@PersistenceContext(unitName = "database")
//	protected EntityManager em;
//
//	protected List<AnuncioPlataforma> localList;
//	protected List<AnuncioPlataforma> selectList;
//
//	public void createEntity(AnuncioPlataforma ent) {
//		em.persist(ent);
//		updateLocalList();
//	}
//
//	public List<AnuncioPlataforma> listEntity(Class<AnuncioPlataforma> entClass) {
//		return localList;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<AnuncioPlataforma> selectAnunPlat(long idAnuncio){
//		selectList = (em.createQuery("SELECT e FROM AnuncioPlataforma e WHERE e.anuncio.id LIKE :idAnuncio").setParameter("idAnuncio", idAnuncio).getResultList());
//	return selectList;	
//	}
//
//	public AnuncioPlataforma getEntity(Class<AnuncioPlataforma> entClass, Long id) {
//		return em.find(entClass, id);
//	}
//
//	public void updateEntity(AnuncioPlataforma ent) {
//		em.merge(ent);
//		updateLocalList();
//		
//	}
//	
//	public void updateEntity2(AnuncioPlataforma ent) {
//		em.merge(ent);
//	}
//
//	public void removeEntity(AnuncioPlataforma ent) {
//		em.remove(em.merge(ent));
//	}
//
//	
//	@SuppressWarnings("unchecked")
//	@PostConstruct
//	protected void loadFromDB() {
//		localList = em.createQuery("SELECT e FROM AnuncioPlataforma e").getResultList();
//	}
//
//	public void updateLocalList() {
//		loadFromDB();
//	}
//	
//	public void updateSelectAnPlat(long idAnuncio) {
//		selectAnunPlat(idAnuncio);
//	}
	
}
