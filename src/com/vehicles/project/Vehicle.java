package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
public String infoVehicle() {
	String info = "";	
	if (wheels.size() < 4) {
			info = "Vehicle amb matrícula " + plate + ", marca " + brand  + ", de color " + color + " amb les rodes " + 			wheels.get(0).getBrand() + " " + wheels.get(0).getDiameter() + " " +  wheels.get(1).getBrand() + " " + 			wheels.get(1).getDiameter(); 
	}else {
		info = " amb matrícula " + plate + ", marca " + brand  + ", de color " + color + "amb les rodes " + 			wheels.get(0).getBrand() + " " + wheels.get(0).getDiameter() + " " +  wheels.get(1).getBrand() + " " + 			wheels.get(1).getDiameter() + " " +  wheels.get(2).getBrand() + " " + wheels.get(2).getDiameter() + " " +  			wheels.get(3).getBrand() + " " + wheels.get(3).getDiameter(); 
	}
		return info;
	}
}
