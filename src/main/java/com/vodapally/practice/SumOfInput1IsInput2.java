package com.vodapally.practice;

import java.util.HashMap;

public class SumOfInput1IsInput2 {

	public static void main(String[] args) {
		int input1[] = {5,0,1,3,2,4};
		int input2 = 5;
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0; i<input1.length; i++) {
			for(int j=i+1; j<input1.length; j++) {
				if((input1[i]+input1[j]) == input2)
					hm.put(input1[i],input1[j]);
			}
		}
		
		System.out.println(hm);
		
		for(Integer i: hm.keySet()) {
			System.out.println(i+"+"+hm.get(i));
		}
	}

}
/*
input1 = [5,0,1,3,2,4]  input2= 5

find all numbers in input1 whose sum is input2
*/