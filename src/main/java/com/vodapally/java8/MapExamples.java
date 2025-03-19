package com.vodapally.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapExamples {

	public static void main(String[] args) {
	//Stream map function can be used to perform some operation on all of it�s elements. 
	//	Java Stream map is an intermediate operation, so it returns Stream.	
	// Before Java 8
		List<String> names = Arrays.asList("Raghavender", "abhinav", "HANEESH");

		List<String> upperCaseNames = new ArrayList<>();
		for(String s:names) {
			upperCaseNames.add(s.toUpperCase());
		}
		System.out.println(upperCaseNames);

		// Using Java 8 lambda
		System.out.println("\nUsing Java 8 lambda");
		names.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
		
		System.out.println("\nUsing Java 8 method ref");
		names.stream().map(String::toUpperCase).forEach(System.out::println);
	}

}
