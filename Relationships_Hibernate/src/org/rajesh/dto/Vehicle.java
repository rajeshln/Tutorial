package org.rajesh.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	private int v_id;
	private String v_name;
	
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	

}
