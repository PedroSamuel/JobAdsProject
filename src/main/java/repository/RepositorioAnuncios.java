
package repository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.Anuncio;

@ApplicationScoped
public class RepositorioAnuncios extends EntityRepository<Anuncio>{


@SuppressWarnings("unchecked")
@PostConstruct
protected void loadFromDB() {
	localList = em.createQuery("SELECT e FROM Anuncio e").getResultList();
}

@Override
public void updateLocalList() {
	loadFromDB();
}
}