package com.vyntrademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Admin  extends User{
	  @NotNull
	  private String name;
	  @Email
	  @NotNull @Column(unique=true)
	  private String email;
	  @NotNull @Column(unique=true)
	  private String phone;
	  @NotNull
	  private String admintype;
	  
	  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdmintype() {
		return admintype;
	}
	public void setAdmintype(String admintype) {
		this.admintype = admintype;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", email=" + email + ", phone=" + phone + ", admintype=" + admintype
				+ ", user_id=" + userId + ", user_password=" + userPassword + "]";
	}
	  
}
