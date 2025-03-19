package com.vodapally.arrays;

public class MultiDimensionArray {

	public static void main(String[] args) {
		// declaring and initializing 2D array
		int myArray[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		// displaying array
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print(myArray[i][j]+" ");
			}
		System.out.println();
		}
		

	}

}
