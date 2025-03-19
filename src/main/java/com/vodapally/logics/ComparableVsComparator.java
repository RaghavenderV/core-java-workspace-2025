package com.abhi.logics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
* Author@ Raghavender Vodapally
* Date@ Jan 21, 2018
*/

class Laptop implements Comparable<Laptop>{
	private String brand;
	private int ram;
	private int price;
	
	public Laptop(String brand, int ram, int price) {
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "laptop [brand=" + brand + ", ram=" + ram + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Laptop lap) {
		if(this.getRam()>lap.getRam()) { //sort based on RAM
			return 1;
		}
		else
			return -1;
	}
	
}

public class ComparableVsComparator {

	public static void main(String[] args) {
		List<Laptop> laps = new ArrayList<>();
		laps.add(new Laptop("Dell", 6, 350));
		laps.add(new Laptop("Apple", 16, 555));
		laps.add(new Laptop("Lenovo", 8, 380));
		laps.add(new Laptop("hp", 4, 200));
		
		Comparator<Laptop> priceComparator = new Comparator<Laptop>() {

			@Override
			public int compare(Laptop l1, Laptop l2) {
				
				if(l1.getPrice()>l2.getPrice())
					return 1;
				else
					return -1;
			}
		};
		
		//Collections.sort(laps);
		Collections.sort(laps, priceComparator);
		
		for (Laptop laptop : laps) {
			System.out.println(laptop);
		}
		
	}

}

//comparator main advantage: no need to change the client application.

