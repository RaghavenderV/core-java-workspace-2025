package com.vodapally.arrays;

import java.util.Scanner;

public class ArraysAddition {
	// need to complete this
	// asked in broadridge
	// [2,10,3]+[8,1,4] = [1,0,1,1,7]

	public static void main(String[] args) {
		System.out.println("How many elements you want for array 'a[]' ??");
		Scanner in = new Scanner(System.in);
		int x= in.nextInt();
		int[] a = new int[x];
		
		System.out.println("Please enter 4 elements for array 'a[]' :");
		for(int i=0;i<x;i++){
			a[i] = in.nextInt();
		}
		
		System.out.println("How many elements you want for array 'b[]' ??");
		int y=in.nextInt();
		int[] b = new int[y];
		
		System.out.println("Please enter 4 elements for array 'b[]' :");
		for(int i=0;i<y;i++){
			b[i] = in.nextInt();
		}
		
		int[] c = new int[50];
		
		int sum = 0, length; 
		String str;
		
		if(x<y){
		for(int i=0; i<x; i++){
			
			sum = a[i]+b[i];
			//c[i] = a[i]+b[i];
			str = sum+"";
			length = str.length();
			
			char[] ch = str.toCharArray();
			
			if(length == 1){
				c[i] = sum;
			}
			else{
				int j;
				for(j=0; j<length; j++){
					c[i+j] = ch[j];
					
				}
				i=i+j;
			}
			
		}
		}
		
		for(int i=0; i<c.length; i++){
			System.out.println(c[i]+" ");
		}

	}

}
