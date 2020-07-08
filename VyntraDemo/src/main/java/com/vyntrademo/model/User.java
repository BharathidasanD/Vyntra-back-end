package com.vyntrademo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long userId;

	@NotNull
	protected String userPassword;
	
	@NotNull
	protected String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getUser_id() {
		return userId;
	}
	public void setUser_id(Long user_id) {
		this.userId = user_id;
	}
	public String getUser_password() {
		return userPassword;
	}
	public void setUser_password(String user_password) {
		this.userPassword = user_password;
	} 
}
