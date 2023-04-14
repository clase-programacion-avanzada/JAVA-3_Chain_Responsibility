package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Owner {
	
	private static Long nextId = 1L;
	
	private long id;
	private int age; 
	private List<Car> cars;
	
	
	public Owner(int age) {
		
		this.id = getNextId();
		this.age = age;
		this.cars = 
				new ArrayList<Car>();
	}


	private long getNextId() {
		return nextId++;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}




	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @return the cars
	 */
	public List<Car> getCars() {
		return cars;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "{id: " + id + "\n"
				+ "age: " + age + "}";
	}


	public void addCar(Car selectedCar) {
		
		cars.add(selectedCar);
		
	}
	
	

	
	
	
	
}
