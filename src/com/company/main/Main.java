package com.company.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.company.model.Car;
import com.company.model.Owner;

public class Main {
	
	private static final List<Owner> OWNERS = new ArrayList<Owner>();
	private static final List<Car> CARS = new ArrayList<Car>();
	
	public static void main(String[] args) {
		
		menu();
		
	}

	private static void menu() {
		Integer option;
        Scanner scanner = new Scanner(System.in);
        do{
                System.out.println("1. Create a new owner");
                System.out.println("2. Create a new car");
                System.out.println("3. Add a new car to owner");
                System.out.println("7. exit");
                
                option = Integer.valueOf(scanner.nextLine());

                switch (option) {
                    case 1 -> addNewOwner();
                    case 2 -> addNewCar();
                    case 3 -> addCarToOwner();
                    case 7 -> System.out.println("Closing application");
                    default -> System.out.println("Not available");
                }
            }
        while (option != 7);
        
        scanner.close();
		
	}

	private static boolean addCarToOwner() {
		
		if(OWNERS.isEmpty()) {
			System.out.println("You don't have owners in your list");
			return false;
		}
		
		if(CARS.isEmpty()) {
			System.out.println("You don't have cars in your list");
			return false;
		}
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Select the owner from the list");
		
		printOwners();
		
		Integer ownerOption = Integer.valueOf(scanner.nextLine());
		
		Owner selectedOwner = OWNERS.get(ownerOption);
		
		System.out.println("Select the car from the list");
		
		printCars();
		
		Integer carOption = Integer.valueOf(scanner.nextLine());
		
		Car selectedCar = CARS.get(carOption);
		
		System.out.println("Car was added succesfully to owner");
		
		selectedOwner.addCar(selectedCar);
		
		selectedCar.setOwner(selectedOwner);
		
		scanner.close();
				
		return true;
		
		
	}

	private static void printCars() {
		for (int i = 0 ; i < CARS.size() ; i++) {
			Car car = CARS.get(i);
			System.out.println(i + ". " + car);
		}
		
	}

	private static void printOwners() {
		
		for (int i = 0 ; i < OWNERS.size() ; i++) {
			Owner owner = OWNERS.get(i);
			System.out.println(i + ". " + owner);
		}
		
	}
	/*
	private static Owner findOwnerById(Long id) {
		
		for (Owner owner : OWNERS) {
			
			if (owner.getId() == id) {
				return owner;
			}
		}
		
	}
	*/

	private static void addNewCar() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Type car's color");
		
		String color = scanner.nextLine();
		
		System.out.println("Type car's year");
		
		Integer year = Integer.valueOf(scanner.nextLine());
		
		System.out.println("Let's set a motor for this car");
		
		System.out.println("Write motor power");
	
		String motorPower = scanner.nextLine();
		
		System.out.println("Write motor capacity");
		
		Integer motorCapacity = Integer.valueOf(scanner.nextLine());
		
		System.out.println("Good, now tell me the brand of the wheels of this car");
		
		String wheelBrand = scanner.nextLine();
		
		System.out.println("Write the type of wheels this car will have");
		
		String wheelType = scanner.nextLine();
		
		/*
		System.out.println("Will this car have airbags? (y/n)");
		
		String airbagsOption = scanner.nextLine();
		
		boolean carHasAirbags = airbagsOption.equalsIgnoreCase("s");
		
		if (carHasAirbags) {
			
			System.out.println("Write the material for the airbags");
			String airbagsMaterial = scanner.nextLine();		
			
		}
		*/
		
		Car car = new Car(
				color,
				year,
				motorPower,
				motorCapacity,
				wheelBrand,
				wheelType
				);
		
		CARS.add(car);
		
		scanner.close();
		
		
	}

	private static void addNewOwner() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Type owner age");
		
		Integer age = Integer.valueOf(scanner.nextLine());
		
        Owner owner = new Owner(age);
        
        //OWNERS = new ArrayList<>();
        
        OWNERS.add(owner);
		
        scanner.close();
	}
	
	

}
