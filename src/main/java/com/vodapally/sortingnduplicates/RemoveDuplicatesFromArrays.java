package com.abhi.sortingnduplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromArrays {

	public static void main(String[] args) {
		//int[] a = new int[]{3, 5, 3, 2, 2, 1, 9};
		String[] cityNames = {"Hyderabad" , "Bangalore", "Mumbai","Johannessburg","Mumbai", "Mumbai"};
		
		// display city names
		ArrayList<String> cityList = new ArrayList<>(Arrays.asList(cityNames));
		System.out.println(cityList);
		
		// remove duplicates using collections
		Set<String> citySet = new HashSet<>(cityList);
		System.out.println(citySet);
		
		Integer[] a = new Integer[]{3, 5, 3, 2, 2, 1, 9};
		ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(a));
		System.out.println("Duplicates int list");
		System.out.println(intList);
		
		// remove duplicates using collections
		Set<Integer> intSet = new HashSet<>(intList);
		System.out.println(intSet);
		

	}

}
