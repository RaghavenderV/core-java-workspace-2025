package com.vodapally.java8;

import java.util.function.Function;

public class StaticMethodReference {

	public static void main(String[] args) {
		//Convert String to Integer
		//Calling parseInt using lambda
		Function<String, Integer> lambdaFunction = (String s)->Integer.parseInt(s);
		Integer i = lambdaFunction.apply("50");
		System.out.println("Conversion Of String 50 to Integer : "+i);
		
		//Calling parseInt using methodRef
		Function<String, Integer> methodRef = Integer::parseInt;
		System.out.println(methodRef.apply("69"));

	}

}
