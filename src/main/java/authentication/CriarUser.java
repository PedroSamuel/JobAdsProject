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
public class CriarUser implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject
	ControlUser controlUser;
	
	private User user;
	
	@PostConstruct
    public void init() {
        user = new User();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User u) {
		user = u;
	}

	public String salvarUser() {
		controlUser.criarUser(user);
		return "listaAnuncios?faces-redirect=true";
	}

	public void criarUser() {
		controlUser.criarUser(new User());
	}



}