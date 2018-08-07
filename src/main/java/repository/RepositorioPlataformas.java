package repository;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import model.Plataforma;

@RequestScoped
public class RepositorioPlataformas extends EntityRepository<Plataforma> {
	
	public List<Plataforma> getAll() {
		return em.createNamedQuery("Plataforma.getAll", Plataforma.class).getResultList();
	}

	public List<Plataforma> getAllWithAnuncios() {
		return em.createNamedQuery("Plataforma.getAllWithAnuncios", Plataforma.class).getResultList();
	}

}
	
	
	
//	@SuppressWarnings("unchecked")
//	@PostConstruct
//	protected void loadFromDB() {
//		localList = em.createQuery("SELECT e FROM Plataforma e").getResultList();
//	}
//
//	@Override
//	public void updateLocalList() {
//		loadFromDB();
//	}

//}
