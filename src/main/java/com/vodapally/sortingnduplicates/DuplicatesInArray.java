package com.vodapally.sortingnduplicates;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicatesInArray {

	public static void main(String[] args) {
		int[] withDuplicates = { 1, 2, 3, 1, 2, 3, 4, 5, 3, 6 };

		Set<Integer> duplicates = findDuplicates(withDuplicates);
		
		System.out.println("input array is  : "+Arrays.toString(withDuplicates));
		System.out.println("Duplicate elements found in array are : "+ duplicates);
		
		//using java 8
		Integer[] numbers = new Integer[]{ 1, 2, 3, 1, 2, 3, 4, 5, 3, 6 };
		Set<Integer> set = new HashSet<>();
		Set<Integer> dupes = Arrays.stream(numbers)
								.filter(n -> !set.add(n))
									.collect(Collectors.toSet());
		
		System.out.println("\nduplicates in { 1, 2, 3, 1, 2, 3, 4, 5, 3, 6 } are :\n"+dupes);

	}

	public static Set<Integer> findDuplicates(int[] input) {

		HashSet<Integer> duplicates = new HashSet<Integer>();
		
		for(int i=0; i<input.length; i++) {
			for(int j=1; j<input.length; j++) {
				if(input[i]==input[j] && i!=j) {
					duplicates.add(input[i]);
				}
			}
		}
		return duplicates;
	}

}
/*
input array is  : [1, 2, 3, 1, 2, 3, 4, 5, 3, 6]
Duplicate elements found in array are : [1, 2, 3]
*/

