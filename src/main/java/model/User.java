package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity

@NamedQueries({
    @NamedQuery(
        name = "User.find",
        query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password"),
    @NamedQuery(
        name = "User.list",
        query = "SELECT u FROM User u"),
   
})
public class User extends Entidade implements Serializable {
	
	private static final long serialVersionUID = -4656759219348212715L;

	  
	  
	  
	  private String username;
	  
	  private String email;
	  
	  private String password;
	  


	
	public String getUsername() {
		return username;
	}

	
	public String getEmail() {
		return email;
	}

	
	public String getPassword() {
		return password;
	}


	
	public void setUsername(String username) {
		this.username = username;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	  

	

}
