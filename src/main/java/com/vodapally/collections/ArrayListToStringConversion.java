package com.abhi.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListToStringConversion {

	public static void main(String[] args) {
		
		String s1="abc";
		String s2=s1;
		String s3=new String("abc");
		String s4 =new String("abc");
		
		System.out.println("== comparison s3==s4 : " + (s3==s4)); //false
		System.out.println("equals comparison : s3.equals(s4) : " + s3.equals(s4)); //true
		
		Set<String> setOfStrings = new HashSet<>();
		
		setOfStrings.add(s1);
		setOfStrings.add(s2);
		setOfStrings.add(s3);
		setOfStrings.add(s4);
		
		System.out.println("\nSize Of Strings : "+setOfStrings.size()); //1
		
		System.out.println("s2 = s3 ?" + s2.equals(s3));//true
		
		System.out.println("s1 = s3 ?" + s1.equals(s3));//true
		
		//Another piece of code
		List<String> list=new ArrayList<>();
		
		list.add("apple");
		list.add("banana");
		list.add("pine-apple");
		list.add("orange");
		list.add("apple");    //list allows duplicate values
		
		String[] stringArray=new String[list.size()];
		
		// Convert list to string
		list.toArray(stringArray);
		
		for(String temp:stringArray){
			System.out.println(temp);
		}
		System.out.println("String Array Size : "+stringArray.length); //5

	}

}
