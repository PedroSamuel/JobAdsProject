package control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.User;
import repository.RepositorioUser;

@Transactional
@RequestScoped
public class ControlUser {
	
	
	@Inject
	RepositorioUser dbU ;
	
	public void criarUser(User user) {
		dbU.createEntity(user);
	}
	
	public List<User> Users(){
		return dbU.getAll();
	}
	
	public User getUser(long id){
		for (User user: Users()){
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User getUser (Long id) {
		return dbU.getEntity(User.class,  id);
		
	}
	
	public void updateUser(User u) {
		dbU.updateEntity(u);
	}
	
	
	public void removeUser(User user) {
		dbU.removeEntity(user);
	}	

}
