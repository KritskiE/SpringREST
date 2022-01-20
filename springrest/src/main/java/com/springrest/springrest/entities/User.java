package com.springrest.springrest.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;
@Entity(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	
	private String firstname;
	private String lastname;
	private String email;
	private String country;
	private String os;
	
	@ManyToMany(mappedBy="users")
	private Set<Social> socials;
	
	public User() {}
	
	public User(int user_id, String firstname, String lastname, String email, String country, String operating_sys) {
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.os = operating_sys;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOperating_sys() {
		return os;
	}
	public void setOperating_sys(String operating_sys) {
		this.os = operating_sys;
	}
	@Override
	public String toString() {
		return "User id: " + user_id + ", firstname: " + firstname + ", lastname: " + lastname + ", email: " + email
				+ ", country: " + country + ", OS: " + os ;
	}
	
	

}
