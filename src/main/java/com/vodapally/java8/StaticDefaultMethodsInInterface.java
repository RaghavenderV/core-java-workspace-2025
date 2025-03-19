package com.vodapally.java8;
/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 5, 2017
 */

interface Vehicle{
	default void print(){
		System.out.println("I am a vehicle!");
	}
	
	static void blowHorn(){
		System.out.println("Blowing Horn!");
	}
	
}


interface FourWheeler{
	default void print(){
		System.out.println("I am a four wheeler!!");
	}
	
}

class Car implements Vehicle, FourWheeler{
	/*@Override
	public void print() {
		// TODO Auto-generated method stub
		FourWheeler.super.print();
	}*/
	
	public void print() {
		System.out.println("I am a Four Wheeler Vehicle!");
	}
	
}

public class StaticDefaultMethodsInInterface {

	public static void main(String[] args) {
		Car car = new Car();
		car.print();
		
		Vehicle.blowHorn();

	}

}

//https://www.tutorialspoint.com/java8/java8_default_methods.htm
//http://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method
/*
Java interface static method is part of interface, we can�t use it for implementation class objects.
Java interface static methods are good for providing utility methods, for example null check, collection sorting etc.
Java interface static method helps us in providing security by not allowing implementation classes to override them.
We can�t define interface static method for Object class methods, we will get compiler error as �This static method cannot hide the instance method from Object�. This is because it�s not allowed in java, since Object is the base class for all the classes and we can�t have one class level static method and another instance method with same signature.
We can use java interface static methods to remove utility classes such as Collections and move all of it�s static methods to the corresponding interface, that would be easy to find and use.*/

