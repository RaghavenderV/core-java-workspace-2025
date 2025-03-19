package com.vodapally.logics;

public class FindMissingNumbers {

	public static void main(String[] args) {
		int[] inputNumbers = {3,4,5,6,8,10};
		
		int[] outputNumbers = findingMissingNumbers(inputNumbers, 1, 10);
		
		// printing the missing numbers
		for(int i=0; i<outputNumbers.length; i++){
			System.out.println(outputNumbers[i]);
		}
		

	}

	private static int[] findingMissingNumbers(int[] numArray, int firstNum, int lastNum) {
		int[] missingNumbers = {}; // to keep missing numbers
		StringBuilder missingNumberBuilder = new StringBuilder();
		
		if(numArray!=null && numArray.length > 0){  // means some elements exist in array
			// before first number in the array
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
		for(int i=1+numArray[numArray.length-1]; i<=lastNum; i++){
			missingNumberBuilder.append(i+ " ");
		}
		
		String[] missingNumberArray = {};
		
		if(!missingNumberBuilder.toString().equals("")){ // found some missing nums
			missingNumberArray = missingNumberBuilder.toString().split(" ");
			missingNumbers = new int[missingNumberArray.length];
			
			for(int i=0; i<missingNumberArray.length; i++){
				missingNumbers[i] = Integer.parseInt(missingNumberArray[i]);
			}
		}

		return missingNumbers;
	}

}
