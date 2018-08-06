package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PreRemove;
import javax.validation.constraints.NotNull;
import javax.persistence.ElementCollection;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;


@Entity
@NamedQueries({
	@NamedQuery(
			name = "User.find",
			query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password"),
	@NamedQuery(
			name = "User.list",
			query = "SELECT u FROM User u"),
	@NamedQuery(
			name = "User.role",
			query = "SELECT u FROM User u WHERE u.roles =  :roles")
})
public class User extends Entidade  {

	@NotNull
	@Column(unique = true)
	private String username;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	private String email;

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull
	private String password;

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@NotNull
	private String roles;

    
	public String getRoles() {
		return roles;
	}

	
	public void setRoles(String roles) {
		this.roles = roles;
	}

	@PreRemove
	private void preRemove() {
		//implementar
	}



	@Override
	public boolean equals(Object other) {
		return (other instanceof User) && (id != null) ? id.equals(((User) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}

}
