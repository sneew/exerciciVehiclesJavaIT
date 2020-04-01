package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Fase 1
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escriu la matricula del cotxe:");
		String plate = sc.next();
		System.out.println("Escriu la marca del cotxe:");
		String brand = sc.next();
		System.out.println("Digues el color del cotxe:");
		String colour = sc.next();
		
		Car car1 = new Car (plate, brand, colour);		
		
		System.out.println("marca de la roda davantera dreta:");
		String frwBrandWR = sc.next();
		System.out.println("diametre de la roda davantera dreta:");
		double frwDiameterWR = sc.nextDouble();		
		
		Wheel wFR = new Wheel (frwBrandWR, frwDiameterWR);
		
		System.out.println("marca de la roda davantera esquerra:");
		String frwBrandWL = sc.next();
		System.out.println("diametre de la roda davantera esquerra:");
		double frwDiameterWL = sc.nextDouble();
		
		Wheel wFL = new Wheel (frwBrandWL, frwDiameterWL);
		
		System.out.println("marca de la roda trasera dreta:");
		String bckBrandWR = sc.next();
		System.out.println("diametre de la roda trasera dreta:");
		double bckDiameterWR = sc.nextDouble();
		
		Wheel wBR = new Wheel (bckBrandWR, bckDiameterWR);
		
		System.out.println("marca de la roda trasera esquerra:");
		String bckBrandWL = sc.next();
		System.out.println("diametre de la roda trasera esquerra:");
		double bckDiameterWL = sc.nextDouble();
		
		Wheel wBL = new Wheel (bckBrandWL, bckDiameterWL);
		
		List<Wheel> frontWls = new ArrayList<Wheel>();
		frontWls.add(wFR);
		frontWls.add(wFL);
		
		List<Wheel> backWls = new ArrayList<Wheel>();
		backWls.add(wBR);
		backWls.add(wBL);
		
		try {
			car1.addWheels(frontWls, backWls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("les rodes no tenen la mateixa marca i/o diàmetre");
		};
		
	}

}
