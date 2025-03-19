package com.vodapally.practice;

import java.util.Arrays;

public class FindMissingNumbers {

	public static void main(String[] args) {
		int[] inputNumbers = {3,4,5,6,8,10};
		
		int[] outputNumbers = findMissingNumbers(inputNumbers, 1, 20);
		
		System.out.println("Original Array : ");
		
		Arrays.stream(inputNumbers).forEach(i -> System.out.print(i+" "));
		
		System.out.println("\n------------------------------");
		System.out.println("\nMissing numbers from 1 to 20 are : ");
		
		// printing the missing numbers
		Arrays.stream(outputNumbers).forEach(i -> System.out.print(i+" "));

	}

	private static int[] findMissingNumbers(int[] numArray, int firstNum, int lastNum) {
		int[] missingNumbers = {}; // to keep missing numbers
		StringBuilder missingNumberBuilder = new StringBuilder();
		
		if(numArray!=null && numArray.length > 0){  // means some elements exist in array
			// build before first number in the array
			for(int i=1; i<numArray[0]; i++){
				missingNumberBuilder.append(i+" ");
			}
		}
		// to check next number exists or not till numArray.length
		for(int i=1; i<numArray.length; i++)
			for(int j=1+numArray[i-1]; j<numArray[i]; j++){
				missingNumberBuilder.append(j+" ");
			}
		
		// Missing numbers between numArray[numArray.length-1] and last number
		for(int i=1+numArray[numArray.length-1]; i<=lastNum; i++){//last element in the array to last number
			missingNumberBuilder.append(i+ " ");
		}
		
		String[] missingNumberArray = {};
		
		if(!missingNumberBuilder.toString().equals("")){ // found some missing numbers
			missingNumberArray = missingNumberBuilder.toString().split(" ");
			missingNumbers = new int[missingNumberArray.length];
			
			for(int i=0; i<missingNumberArray.length; i++){
				missingNumbers[i] = Integer.parseInt(missingNumberArray[i]);
			}
		}

		return missingNumbers;
	}

}
