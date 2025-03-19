package com.vodapally.collections;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Author@ Siri-Raghu
 * Date@ 15-Oct-2014
 */
public class FrequencyMethodInCollections {

	public static void main(String[] args) {
		// to find the frequency of an object using frequency method
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(10);
		myList.add(20);
		myList.add(10);
		myList.add(30);
		myList.add(10);
		myList.add(40);
		myList.add(20);
		
		System.out.println("Elements of Array List : " + myList);
		
		int frequency = Collections.frequency(myList, 10);
		
		System.out.println("Frequency of 10 is : " + frequency);
		
	//	Collections.sort(list)
		
		// string occurance : my own logic
		String str ="I love India. I love Java. love";
		String[] strArray = str.split(" ");
		ArrayList<String> al = new ArrayList<>();
		
		for(String s: strArray) {
			al.add(s);
		}
		
		//System.out.println(al);
		
		int a = Collections.frequency(al, "love");
		
		System.out.println(str);
		System.out.println("love occurance in above string : "+ a);
	}
}

