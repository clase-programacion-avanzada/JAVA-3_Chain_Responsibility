package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
	private static Long nextId = 0L;

	private Owner owner;
	private long id;
	private String color;
	private int year;
	private List<Airbag> airbags;
	private Motor motor;
	private List<Wheel> wheels;
	
	
	public Car(
			String color, 
			int year, 
			//motor attributes
			String motorPower,
			int motorCapacity,
			//wheel attributes
			String wheelBrand,
			String wheelType
			) {
			
		this.id = getNextId();
		this.color = color;
		this.year = year;
		
		this.airbags = new ArrayList<Airbag>();
		
		this.motor = new Motor(
				motorPower, 
				motorCapacity);
		
		this.wheels = new ArrayList<Wheel>();
		
		for(int i = 0 ; i < 4 ; i++) {
			Wheel wheel = 
					new Wheel(
							wheelBrand, 
							wheelType);
			this.wheels.add(wheel);
		}
		
		
	}


	private static Long getNextId() {
		
		return nextId++;
	}


	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @return the airbags
	 */
	public List<Airbag> getAirbags() {
		return airbags;
	}


	/**
	 * @return the motor
	 */
	public Motor getMotor() {
		return motor;
	}


	/**
	 * @return the wheels
	 */
	public List<Wheel> getWheels() {
		return wheels;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @param airbags the airbags to set
	 */
	public void setAirbags(List<Airbag> airbags) {
		this.airbags = airbags;
	}


	/**
	 * @param motor the motor to set
	 */
	public void setMotor(Motor motor) {
		this.motor = motor;
	}


	/**
	 * @param wheels the wheels to set
	 */
	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}


	public void setOwner(Owner selectedOwner) {
		
		this.owner = selectedOwner;
		
	}


	@Override
	public String toString() {
		return "Car [owner=" + owner + ", id=" + id + ", color=" + color + ", year=" + year + ", airbags=" + airbags
				+ ", motor=" + motor + ", wheels=" + wheels + "]";
	}
	
	
	
	
	
	
	
}
