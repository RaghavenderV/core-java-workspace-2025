package com.vodapally.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ReorderDigitsOfEachNumber {

	public static void main(String[] args) {
		int numArray[] = new int[] {515, 341, 98, 44, 211};//output:[155, 134, 89, 44, 112]
		for (int i = 0; i < numArray.length; i++) {
			sortDigitsInEachNumber(numArray[i]);
		}
		
		//Arrays.stream(numArray).forEach(System.out::println);
		
		
	}
	
	public static void sortDigitsInEachNumber(int number) {
		List<Integer> list = new LinkedList<>();
		for(int i=number; i>0; i=i/10) {
			list.add(i%10);
		}
		list.stream().sorted().forEach(i->System.out.print(i));
		System.out.print(" ");
	}

}
