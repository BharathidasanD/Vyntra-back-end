package com.vyntrademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Customer extends User {
	
	  @NotNull
	  private String name;
	  @NotNull @Column(unique=true)
	  private String email;
	  @NotNull @Column(unique=true)
	  private String phone;
	  @NotNull
	  private String address;
	  @NotNull
	  private String pincode;
	  @NotNull 
	  private String city;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", pincode=" + pincode + ", city=" + city + ", user_id=" + userId + ", user_password="
				+ userPassword + "]";
	}
	
	
}
