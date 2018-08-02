package authentication;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;



import control.ControlUser;
import model.User;


@Named ("criarUser")
@ViewScoped
public class Register implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2801507022043885551L;
	
	
	@Inject
	ControlUser controlUser;
	
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User u) {
		user = u;
	}

	public String salvarAnuncio() {
		controlUser.criarUser(user);
		return "listaAnuncios?faces-redirect=true";
	}

	public void criarAnuncio() {
		controlUser.criarUser(new User());
	}



}