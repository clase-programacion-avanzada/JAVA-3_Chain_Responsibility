package com.company.model;

public class Motor {
	
	private String power; 
	private int capacity;
	
	public Motor() {
		this.power = "200HP";
		this.capacity = 300; 
	}
	
	public Motor(
			String power, 
			int capacity) {
		this.power = power;
		this.capacity = capacity;
	}


	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}


	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}


	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}


	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	} 
	
	
}
