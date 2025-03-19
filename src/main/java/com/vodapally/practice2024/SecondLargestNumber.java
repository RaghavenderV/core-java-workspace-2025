package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecondLargestNumber {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,20,10,90,80,90);
		
		//find second-largest number from list
		Integer secondLarge = list.stream().distinct().sorted(Comparator.reverseOrder())
			.skip(1)
			.findFirst()//returns Optional
			.get(); //returns integer
		
		System.out.println(list+"\n"+"Second Largest from List -> "+secondLarge); //90
		
		//find second-largest number from array
		int[] intArray = {10,20,10,90,80,90};
		Integer result = Arrays.stream(intArray).boxed().distinct()
				.sorted(Comparator.reverseOrder())
				.skip(1).findFirst().get();


		System.out.println("Second Largest from array -> "+result); //90			
	}

}
