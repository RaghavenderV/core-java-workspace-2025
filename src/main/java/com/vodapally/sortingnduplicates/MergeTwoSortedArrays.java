package com.abhi.sortingnduplicates;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7};
		int n1 = arr1.length;
		
		int[] arr2 = {2,4,6,8,33,99};
		int n2 = arr2.length;
		
		int[] arr3 = new int[n1+n2];
		
		mergeArrays(arr1, arr2, n1, n2, arr3);
		
		System.out.println("Array after merging");
		for(int i=0; i<n1+n2; i++)
			System.out.print(arr3[i]+ " ");

	}

	public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
		int i=0, j=0, k=0;
		//traverse both arrays
		while(i<n1 && j<n2) {
			//Check if current element of first array is smaller than current element 
			//of second array. If yes, store first array element and increment first array index.
			//Otherwise do same with second array.
			if(arr1[i] <arr2[j])
				arr3[k++]=arr1[i++];
			else
				arr3[k++]=arr2[j++];
		}
			//store remaining elements of first array
			while(i<n1)
				arr3[k++] = arr1[i++];
			
			//store remaining elements of second array
			while(j<n2)
				arr3[k++] = arr2[j++];
		
	}

}
