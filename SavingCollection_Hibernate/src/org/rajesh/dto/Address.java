package org.rajesh.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable// tells hibernate that this object is part of other object 
public class Address {
	
	@Column (name="STREET")
	private String street;
	
	@Column (name="CITY")
	private String city;
	
	@Column (name="STATE")
	private String state;
	
	@Column(name="PIN_CODE")
	private String pincode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
