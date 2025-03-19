package com.vodapally.collections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class HashtableToArrayListConversion {

	public static void main(String[] args) {
		Hashtable<String, Integer> hashtable=new Hashtable<String, Integer>();
		hashtable.put("raghu", 1500);
		hashtable.put("cnu", 2540);
		hashtable.put("madhu", 8500);
		hashtable.put("malli", 9999);
		
		// Convert to ArrayList
		
		ArrayList<String> keysList=new ArrayList<String>(hashtable.keySet());
		
		System.out.println("HashTable keys in ArrayList : "+keysList);
		
		// Using iterator
		System.out.println("Using Iterator");
		Iterator<String> i=keysList.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		System.out.println("Using for:each loop");
		
		//Using for each loop
		for(String temp:keysList)
			System.out.println(temp);
		
		
		ArrayList<Integer> values=new ArrayList<Integer>(hashtable.values());
		
		System.out.println("HashTable values in ArrayList : "+values);
		
		//Using for-each loop
		for(Integer temp: values){
			System.out.println(temp);
		}

	}

}
