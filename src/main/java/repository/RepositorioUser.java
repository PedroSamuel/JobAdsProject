package repository;

import java.util.List;



import javax.enterprise.context.RequestScoped;

import model.User;

@RequestScoped
public class RepositorioUser extends EntityRepository <User> {

	
	public List<User> getAll() {
		return em.createNamedQuery("User.getAll", User.class).getResultList();
	}


}
