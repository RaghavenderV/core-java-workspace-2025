package com.vodapally.practice2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://www.youtube.com/watch?v=Ofl4KgFhLsM
public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		int[] array = { 15, 2, 4, 8, 9, 5, 10, 23 };// sum = 23 -> o/p: 2 5
		int givenSum = 23;

		// Sum of elements between indices 2 and 5 is 2 + 4 + 8 + 9 = 23

		// int[] array1 = {1, 4, 0, 0, 3, 10, 5}; // sum = 7 -> o/p: 2 5
		// int givenSum = 20;

		// int[] array2 = {1, 4}; // sum = 0 -> o/p: -1 as there is no subarray with Sum
		// 0

		int n = array.length;

		ArrayList<Integer> outputList = subArraysum(array, n, givenSum);

		System.out.println(outputList);

	}

	private static ArrayList<Integer> subArraysum(int[] array, int n, int givenSum) {

		ArrayList<Integer> outputList = new ArrayList<>();
		int i = 0;
		int sum = 0;

		for (int j = 0; j < n; j++) { //  { 15, 2, 4, 8, 9, 5, 10, 23 }
			sum = sum + array[j];

			while(sum > givenSum) { //givenSum=23-> o/p: 2+4+8+9=23-> indices-> 2 and 5
				sum = sum - array[i];
				i++;
			} // while

			if (sum == givenSum && i <= j) {
				outputList.add(i + 1);
				outputList.add(j + 1);
				return outputList;
			}
			// return outputList.add(-1);
		} // for

		outputList.add(-1);

		return outputList;

	}

}
