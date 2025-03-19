package com.vodapally.practice;

import java.util.Arrays;

/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 2, 2017
 */

public class BubbleSort {

	public static void main(String[] args) {
		int[] unsortedArray = {6,4,1,3,2,5};
		
		System.out.println("Before Bubble Sort:");
		displayArray(unsortedArray);
		
		//do bubble sort
		bubbleSort(unsortedArray);
		
		System.out.println("\n\nAfter Bubble Sort:");
		displayArray(unsortedArray);
		
		System.out.println("\n\nUsing Arrays.sort()");
		int[] unsortedArray1 = new int[]{6,4,1,3,2,5};
		Arrays.sort(unsortedArray1);
		displayArray(unsortedArray1);

	}
	
	public static void displayArray(int[] unsortedArray){
		Arrays.stream(unsortedArray).forEach(i -> System.out.print(i+" "));
	}
	
	
	
	public static void bubbleSort(int[] array){
		int n = array.length;
		int temp;
		
		for(int i=0; i<n; i++)
			for(int j=1; j<(n-i); j++){
				
				if(array[j-1] > array[j]){
					//next element is greater than previous element; swap it
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
	}
}


