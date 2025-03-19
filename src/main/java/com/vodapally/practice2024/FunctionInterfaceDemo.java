package com.vodapally.practice2024;

import java.util.function.Function;

public class FunctionInterfaceDemo {

	public static void main(String[] args) {
		//Function interface takes in one argument and produces a result
		// R apply(T) 
		Function<String, String> convertToUpperCase = str -> str.toUpperCase();
		System.out.println(convertToUpperCase.apply("pragati maha vidyalaya")); // PRAGATI MAHA VIDYALAYA
		
		//custom Function interface
		int test = 81;
		Function<Integer, Integer> sqrtFunction = a ->(int) Math.sqrt(a);
		System.out.println("Square root  "+test+" is : "+sqrtFunction.apply(test)); // Square root  81 is : 9
		
		
		//default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
		//It returns a composed function where in the parameterized function 
		//will be executed after the first one.
		//https://www.geeksforgeeks.org/function-interface-in-java-with-examples/
		
		int x = 121;
		Function<Integer, Integer> result = num -> (int) Math.sqrt(num); // this is applied first
		Function<Integer,Integer> andThenFunc = result.andThen(i -> i * 3);
		System.out.println("Result : "+ andThenFunc.apply(x)); //Result : 33
		
		
		
		
		//compose() -> it is reverse to andThen
		
		int y = 3;
		Function<Integer, Integer> res = num -> (int) Math.sqrt(num); 
		Function<Integer,Integer> composeFunc = res.compose(i -> i * 3);// this is applied first
		System.out.println("Result : "+ composeFunc.apply(y));//Result : 3
		
		
		
		//identity() method returns a function that returns its only argument
		int var = 41;
		Function<Integer, Integer> idFunc = Function.identity();
		System.out.println("Result -> "+idFunc.apply(var)); //Result -> 41
		
		
	}

}
