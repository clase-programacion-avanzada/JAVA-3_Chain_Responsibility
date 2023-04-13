package com.company.model;

public class Wheel {
	
	private String brand;
	private String type;
	
	public Wheel(
			String brand, 
			String type) {
		
		this.brand = brand;
		this.type = type;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	} 
	
	
}
