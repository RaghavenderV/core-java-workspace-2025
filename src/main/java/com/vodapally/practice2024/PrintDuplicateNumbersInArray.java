package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintDuplicateNumbersInArray {

	public static void main(String[] args) {
		
		int[] a = {5,5,6,1,9,9,9,7,4,9};
		System.out.println("Input : \n"+Arrays.toString(a));

		System.out.println("Find and print duplicate numbers in array");
		Arrays.stream(a).boxed()
			  .collect(Collectors.groupingBy(e->e, Collectors.counting())) //here returns Map<Integer, Long> means Integer=element, Long=count
			  .entrySet()
			  .stream()
			  .filter(entry -> entry.getValue()>1) // filter values which are >1
			  .map(Map.Entry::getKey) //extract keys from the Entry
			  .forEach(System.out::println);//5,9


		System.out.println("\nMethod-2 ");
		Stream.of(a).flatMapToInt(Arrays::stream).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue()>1)
				.map(Map.Entry::getKey)
				.forEach(n -> System.out.print(n+" "));


		int[] intArray = {5,5,6,1,9,9,9,7,4,9};
		
		//Find and print duplicate numbers and its occurrence 5->2, 9->4
		System.out.println("\n******************************************");
		System.out.println("Find and print duplicate numbers and its occurrence ");
		Arrays.stream(intArray)
			  .boxed()
			  .collect(Collectors.groupingBy(e->e, Collectors.counting())) //here returns Map<Integer, Long> means Integer=element, Long=count
			  .entrySet()
			  .stream()
			  .filter(entry -> entry.getValue()>1)
			  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
			  .forEach((k,v) -> System.out.println(k+" -> "+v));



		System.out.println("\n******************************************");
		System.out.println("Remove duplicates from array");
		
		int[] array = Arrays.stream(intArray).distinct().toArray();
		
		System.out.println(Arrays.toString(array));
		
		
		
		
		
		
		

	}

}
