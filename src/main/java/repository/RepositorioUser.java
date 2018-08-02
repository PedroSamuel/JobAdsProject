package repository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.User;

@ApplicationScoped
public class RepositorioUser extends EntityRepository <User> {

	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM User e").getResultList();
	}
	
	
	@Override
	public void updateLocalList() {
		// TODO Auto-generated method stub
		
	}

}
