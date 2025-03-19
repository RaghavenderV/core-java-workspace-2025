package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressionDemo {

	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Hyderabad", "Mumbai", "Bangalore", "Chennai" , "Johannessburg");
		
		System.out.println("To print values earlier to java 1.8");
		for(String str: cities){
			System.out.print(str + "\t");
		}
		
		System.out.println("\n\nTo Print using Java 8 in more readable way using Type");
		cities.forEach((String str)-> System.out.print(str + "\t"));
		
		System.out.println("\nTo Print using Java 8 with out using Type");
		cities.forEach(value -> System.out.println(value + "\t"));
		
		System.out.println("\nTo Print using Java 8 using :: operator");
		cities.forEach(System.out::println);
		

	}

}
