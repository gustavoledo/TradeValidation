package com.creditsuisse.rest.model;

public class Rates {

	
	private String name;
	private Double value;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}

	
	
	
	@Override
	public String toString() {
		return "Rates [name=" + name + ", value=" + value + "]";
	}
	
	
	
	
}
