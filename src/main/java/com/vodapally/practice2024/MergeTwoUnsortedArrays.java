package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoUnsortedArrays {

	public static void main(String[] args) {
		
		// merge two unsorted arrays into single sorted array
		int[] a = new int[] {4, 2, 7, 1};
        
        int[] b = new int[] {8, 3, 9, 5};
        
        int[] array = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
        							.sorted().toArray();
        
        System.out.println(Arrays.toString(array)); // [1, 2, 3, 4, 5, 7, 8, 9]

	}

}
