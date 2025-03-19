package com.vodapally.sortingnduplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringsSortWithoutCollection {
	static String name[]={"Raghu","Surendra","Dora","Rajesh","Amar"};
	
	public static void main(String[] args) {
		String temp=null;
		for (int i = 0; i < name.length; i++) {
			for (int j = i+1; j < name.length; j++) {
				if(name[j].compareTo(name[i])<0){
					//Swapping string
					temp=name[i];
					name[i]=name[j];
					name[j]=temp;
				}
			}
			
		}
		
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		
		String names[]={"Raghu","Surendra","Dora","Rajesh","Amar"};
		
		System.out.println("\nSort Using Colleciotns..");
		Collections.sort(Arrays.asList(names));
		Arrays.sort(names);
		
		//display using Java 8
		String namesArray[]={"Raghu","Surendra","Dora","Rajesh","Amar"};
		List<String> list = new ArrayList<>(Arrays.asList(namesArray));
		list.stream().sorted().forEach(System.out::println);;
		
		
	}

}
