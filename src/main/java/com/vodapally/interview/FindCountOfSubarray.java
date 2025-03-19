package com.vodapally.interview;

public class FindCountOfSubarray {

	public static void main(String[] args) {
		//input : 1,2,3
		//k=3 -> target
		//Logic: 1,2 and 3
		//output: 2
		
		int arr[] = {1,2,3};
		int k=3;
		int n = arr.length;
		int result = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int sum =0;
			for (int j = i; j < arr.length; j++) {
				sum = sum+arr[j];
				if(sum == k)
					result++;
			}
		}
		
		System.out.println("Number of subarrays that sums upto "+ k +" is "+result);

	}

}
