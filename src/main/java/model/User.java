package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.ElementCollection;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import authentication.Role; 

@Entity
@NamedQueries({
	@NamedQuery(
			name = "User.find",
			query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password"),
	@NamedQuery(
			name = "User.list",
			query = "SELECT u FROM User u"),
//	@NamedQuery(
//			name = "User.role",
//			query = "SELECT u FROM User u WHERE u.roles =  :roles")

})
public class User extends Entidade implements Serializable {

	private static final long serialVersionUID = -4656759219348212715L;




	private String username;
	

	public String getUsername() {
		return username;
	}


	public String getEmail() {
		return email;
	}
	
	

	private String email;
	
	

	public void setUsername(String username) {
		this.username = username;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	private String password;
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	//@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	//@Enumerated(EnumType.STRING)
	//@CollectionTable(name = "UserRoles", joinColumns = { @JoinColumn(name = "userId") })
	//@Column(name = "role")
	//private List<Role> roles;


	
	//public List<Role> getRoles() {
	//	return roles;
	//}


	
	//public void setRoles(List<Role> roles) {
	//	this.roles = roles;
	//}


}
