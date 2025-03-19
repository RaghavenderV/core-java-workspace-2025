package com.vodapally.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FIndDuplicatesInIntegers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,11,11,20,35,13,15,59,59); // 11 59
		
		//HashSet to store duplicate elements
		Set<Integer> items = new HashSet<>();
		
		// Set.add() returns false
        // if the element was already present in the set.
        // Hence filter such elements
		
		Set<Integer> set = list.stream()
								.filter(n -> !items.add(n))
								.collect(Collectors.toSet());
		System.out.println("Duplicates: ");
		set.forEach(System.out::println);
		
		//Approach-2 for the above solution
		Set<Integer> set2 = list.stream()
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			.entrySet()
			.stream()
			.filter(entry -> entry.getValue()>1)
			.map(entry -> entry.getKey())
			.collect(Collectors.toSet());
		
		System.out.println("\nDuplicates: ");
		set2.forEach(System.out::println);

		//Find max element in list 
		Integer max = list.stream()
			.max(Integer::compare)
			.get();
		System.out.println("Max element in list : "+max);
		
		Integer sum = list.stream().reduce(0,(a,b) -> a+b);
		
		System.out.println("Sum of elements in list : "+sum);
		
		//Sorting
		System.out.println("\nSorting: ");
		list.stream()
			.sorted()
			.forEach(System.out::println);
	}

}
