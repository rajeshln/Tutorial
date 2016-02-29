package com.model;

public class Circle {
	int id ;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Circle(int circleid,String name){
		setId(circleid);
		setName(name);
	}

}
