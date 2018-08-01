package model;

import java.io.Serializable;

public class User extends Entidade implements Serializable {
	
	private static final long serialVersionUID = -4656759219348212715L;

	  
	  
	  
	  private String username;
	  
	  private String email;
	  
	  private String password;
	  
	  private String salt;

	
	public String getUsername() {
		return username;
	}

	
	public String getEmail() {
		return email;
	}

	
	public String getPassword() {
		return password;
	}

	
	public String getSalt() {
		return salt;
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

	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	  
	  

	

}
