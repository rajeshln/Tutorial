package org.rajesh.dto;

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
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity 
@Table (name="USER_DETAILS_COLL")
public   class UserDetails {

	//Setting the set of addresses
	@ElementCollection(fetch=FetchType.EAGER)  // create a separate table for address
	private Set<Address> addresses = new HashSet<Address>();
	
	
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	// we can put annotation on getter and setters also
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE) // strategy for maintain key
	@Column (name="USER_ID")
	private int userid;
	
	//@Transient // will ask hibernate to ignore this field
	@ Column(name="USER_NAME")
	private String name;
	
	
	//@Temproal used for date
	
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
