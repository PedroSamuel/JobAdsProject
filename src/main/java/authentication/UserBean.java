package authentication;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlUser;
import model.User;


@Named("userBean")
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private User selected;
  
	@Inject
	ControlUser userControl;
	
	
	private Collection<User> userList;
	
	public void removeUser(User user) {
		userControl.removeUser(user);
		loadUsers();
	}
	
	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}

	public User getSelected() {
		return selected;
	}

	public void setSelected(User selected) {
		this.selected = selected;
	}
	
	@PostConstruct
	public void loadUsers() {
		setUserList(userControl.Users());
		
	}
		
	
}
