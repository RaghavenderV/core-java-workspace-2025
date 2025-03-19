package com.vodapally.java8;

import java.util.Arrays;
import java.util.Collections;

public class SortPrimitveArrayDesc {

	public static void main(String[] args) {
		int numArray[] = new int[] {6,1,8,5,2};
		
		//Reverse Sorting
		int[] sorted = Arrays.stream(numArray).boxed().sorted(Collections.reverseOrder())
		.mapToInt(Integer::intValue).toArray();
		
		for (int i : sorted) {
			System.out.print(i+" ");
		}
		
		System.out.println("\nAsceding Order ");
		int intArray[] = new int[] {56,86,6,1,8,5,2,99};
		Arrays.stream(intArray).boxed().sorted().forEach(n -> System.out.println(n+" "));

	}

}
