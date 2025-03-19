package com.abhi.java8;
/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 5, 2017
 */

interface GreetingService{
	public abstract void sayMessage(String message);
}

public class LambdaDemo {

	final static String salutation = "Hello! ";
	
	public static void main(String[] args) {
		GreetingService gs = message -> System.out.println(salutation+message);
		
		gs.sayMessage("Raghavender");

	}

}

