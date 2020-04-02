package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String plate, brand, colour, vehicle;
		Wheel wheelB1, wheelB2, wheelC1, wheelC2, wheelC3, wheelC4;
		
		//tria de vehicle, si moto o cotxe:
		System.out.println("indica si vols introduir un cotxe o una moto (escriu cotxe o moto)");
		vehicle = sc.next();

		if (vehicle.equals("moto")) {
			plate = validarMatricula(sc);
			brand = preguntarMarca(sc);
			colour = preguntarColor(sc);
			// creem la moto
			Bike bike1 = new Bike (plate, brand, colour);
			
			//creem rodes
			wheelB1 = crearRoda(sc);
			wheelB2 = crearRoda(sc);
			
			//asociem les dues rodes a cada arraylist corresponents
			List<Wheel> frontWls = new ArrayList<Wheel>();
			frontWls.add(wheelB1);
			
			List<Wheel> backWls = new ArrayList<Wheel>();
			backWls.add(wheelB2);
			
			//posem les rodes creades al cotxe abans creat
			try {
				bike1.addWheels(frontWls, backWls);
			} catch (Exception e) {
				System.out.println("les rodes no tenen la mateixa marca i/o diàmetre");
			};
			
			System.out.println(bike1.infoVehicle());

		} else if (vehicle.equals("cotxe")) {
			plate = validarMatricula(sc);
			brand = preguntarMarca(sc);
			colour = preguntarColor(sc);
			// creem el cotxe
			Car car1 = new Car (plate, brand, colour);
			
			//creem rodes
			wheelC1 = crearRoda(sc);
			wheelC2 = crearRoda(sc);
			wheelC3 = crearRoda(sc);
			wheelC4 = crearRoda(sc);
			
			//asociem les dues rodes a cada arraylist corresponents
			List<Wheel> frontWls = new ArrayList<Wheel>();
			frontWls.add(wheelC1);
			frontWls.add(wheelC2);
			
			List<Wheel> backWls = new ArrayList<Wheel>();
			backWls.add(wheelC3);
			backWls.add(wheelC4);
			
			//posem les rodes creades al cotxe abans creat
			try {
				car1.addWheels(frontWls, backWls);
			} catch (Exception e) {
				System.out.println("les rodes no tenen la mateixa marca i/o diàmetre");
			};
			
			System.out.println(car1.infoVehicle());
		}
		
		
	}

	private static String validarMatricula(Scanner s) {
		Scanner sc = s;
		String plate;
		boolean isValidPlate = false;
		
		//agafem i validem matricula
		System.out.println("Escriu la matricula del vehicle:");
		do {
			plate = sc.next();
			Matcher m = Pattern.compile("\\d\\d\\d\\d[A-Z][A-Z]|\\d\\d\\d\\d[A-Z][A-Z][A-Z]").matcher(plate);
			if (m.find()) {
			    System.out.println(plate + " és una matrícula vàlida");
			    isValidPlate = true;
			} else {
			    System.out.println(plate + " no és una matrícula vàlida, ha de tenir 4 números i dues o tres lletres MAJÚSCULES, torna-hi:");
			    isValidPlate = false;
			}
		}while(!isValidPlate);

		return plate;
	}

	private static String preguntarMarca(Scanner s) {
		Scanner sc = s;
		System.out.println("Escriu la marca del vehicle:");
		String brand = sc.next();
		return brand;
	}
	
	private static String preguntarColor(Scanner s) {
		Scanner sc = s;
		System.out.println("Digues el color del vehicle:");
		String colour = sc.next();
		return colour;
	}
	
	private static Wheel crearRoda(Scanner s) {
		// creem les rodes
		Scanner sc = s;
		boolean isValidDiameter = false;
		String wheelBrand;
		double wheelDiameter;

		System.out.println("marca de la roda:");
		wheelBrand = sc.next();
				
		//demanem i comprovem diametre rodes
		System.out.println("diametre de la roda:");
		do {
		    wheelDiameter = sc.nextDouble();
		    if (wheelDiameter >= 0.4 && wheelDiameter <= 4) {
		        isValidDiameter = true;
		    } else {
		        System.out.println("el diàmetre ha de ser de 0.4 a 4, torna'l a introduïr: ");
		        isValidDiameter = false;
		    }
		}while(!isValidDiameter);
		
		Wheel wheel = new Wheel (wheelBrand, wheelDiameter);

		return wheel;
	}
}
