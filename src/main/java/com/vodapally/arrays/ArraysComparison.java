package com.vodapally.arrays;

import java.util.Arrays;

public class ArraysComparison {

	public static void main(String[] args) {
		int[] a = {3,0,5,5};
		int[] b = {3,0,5,5};
		
		if(Arrays.equals(a, b)){
			System.out.println("EQUAL");
		}
		else{
			System.out.println("NOT EQUAL");
		}

	}

}
