package com.capgemini.model;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="tusers")
public class User {
	
	@Id
	private long id;
	
	private String login;
	private String email;
	private String password;
	private UserStatus status;
	private boolean isAdmin;

	
	public User(long id, String login, String email, String password) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.password = password;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserStatus getStatus() {
		return status;
	}


	public void setStatus(UserStatus status) {
		this.status = status;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}



	@Override
	public int hashCode() {
		return Objects.hash(email, id, isAdmin, login, password, status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && isAdmin == other.isAdmin
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}
	
	
	
	
	
	
}
