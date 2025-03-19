package com.vodapally.abstractdemo;
/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 11, 2017
 */

//abstract class can have main method and we can run also
public abstract class AbstractHasMain {
	
	
	public static void display() {
		System.out.println("static method in abstract class");
	}
	 
	
	public static void main(String[] args) {
		System.out.println("in main");
		
		AbstractHasMain.display();
	}

}

