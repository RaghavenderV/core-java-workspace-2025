package com.vodapally.practice2024;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigitsOfANumber {

	public static void main(String[] args) {
		// Find sum of all digits of a number in Java 8?
		
		int num = 3055;
		
		//1. convert int to string
		//2. then split, will get string array -> use Stream.of
		//3. collect after parsing and summing
		
		Integer sum = Stream.of(String.valueOf(num).split(""))
			  .collect(Collectors.summingInt(Integer::parseInt)); //str -> Integer.parseInt(str)=Integer::parseInt
		
		System.out.println("Sum of "+num+" is : "+sum);
		
		


	}

}
