package com.vodapally.interview;

import java.util.Arrays;
//return the indices of summing target
public class SummingIndices {

	public static void main(String[] args) {
		int[] array = {1,4,5,7};
		int target=8;//e.g: 8=1+7 -> indices {0,3}
		int[] result = sum(array,target);
		Arrays.stream(result).forEach(i-> System.out.print(i+" "));
		
	}
	
	public static int[] sum(int array[], int target) {
		int[] result= new int[2];

		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(target ==array[i]+array[j]) {
					result[0]=i;
					result[1]=j;
					break;
				}
			}
		}
		return result;
	}

}
