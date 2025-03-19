package com.abhi.sortingnduplicates;

/*
* Author@ Raghavender Vodapally
* Date@ Feb 5, 2018
*/
public class DisplayAndRemoveDuplicateIntArray {

	public static void main(String[] args) {
		int[] intArray = new int[] { 1, 2, 3, 4, 5, 1, 2};//duplicates: 1,2

		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[i] == intArray[j] ) {
					System.out.println(intArray[j] + " ");
				}
			}

		}

	}

}
