package com.springrest.springrest.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity(name="social")
public class Social {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int social_id;
	
	private String platform;
	private String region;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="social_us",joinColumns = @JoinColumn(name = "social_id",referencedColumnName="social_id"),
	inverseJoinColumns=@JoinColumn(name="user_id",referencedColumnName="user_id"))
	private Set<User> users;
	
	public Social() {}
	
	public Social(int social_id, String soc_name, String region) {
		this.social_id = social_id;
		this.platform = soc_name;
		this.region = region;
	}
	public int getSocial_id() {
		return social_id;
	}
	public void setSocial_id(int social_id) {
		this.social_id = social_id;
	}
	public String getSoc_name() {
		return platform;
	}
	public void setSoc_name(String soc_name) {
		this.platform = soc_name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "Social id : " + social_id + ", platform : " + platform + ", region : " + region;
	}
	
	

}
