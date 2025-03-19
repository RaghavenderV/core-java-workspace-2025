package com.vodapally.logics;

import java.util.Arrays;

public class FindSecondHighestNumber {

	public static void main(String[] args) {
		int numbers[]= {32,56,1,98,45,100};
		Arrays.sort(numbers);
		System.out.println("First Highest :"+numbers[numbers.length-1]);
		System.out.println("Second Highest :"+numbers[numbers.length-2]);

	}

}
