package org.rajesh.dto;


/* one to one relationship example */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity 
@Table (name="USER_DETAILS_MAPPINGS")
public   class UserDetails {

// we can put annotation on getter and setters also
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE) // strategy for maintain key
	@Column (name="USER_ID")
	private int userid;
	
	//@Transient // will ask hibernate to ignore this field
	@ Column(name="USER_NAME")
	private String name;
	
	
	
	@OneToOne // need to provide this else get  Could not determine type for: org.rajesh.dto.Vehicle
	private Vehicle vehicle;
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
