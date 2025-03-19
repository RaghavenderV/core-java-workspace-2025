package com.vodapally.sortingnduplicates;

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
		for(int i:unsortedArray){
			System.out.print(i+" ");
		}
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

/*(n-i) -- in each iteration, we are eliminating highest number
 * In bubble sort, we basically traverse the array from first to
 * array_length - 1 position and compare the element with the next one.
 * Element is swapped with the next element if the next element is greater.
 * 
 * Bubble sort steps are as follows.
 * 
 * 1. Compare array[0] & array[1] 
 * 2. If array[0] > array [1] -> swap it. 
 * 3. Compare array[1] & array[2] 
 * 4. If array[1] > array[2] swap it. ... 
 * 5. Compare array[n-1] & array[n] 
 * 6. if [n-1] > array[n] then swap it.
 * 
 * After this step, we will have largest element at the last index.
 * 
 * Repeat the same steps for array[1] to array[n-1]
 */

