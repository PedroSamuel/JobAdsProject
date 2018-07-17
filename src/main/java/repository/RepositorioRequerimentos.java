package repository;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.Requerimento;


@ApplicationScoped
public class RepositorioRequerimentos extends EntityRepository <Requerimento>{
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM Requerimento e").getResultList();
	}

	@Override
	public void updateLocalList() {
		loadFromDB();
	}
	
	
	

}
