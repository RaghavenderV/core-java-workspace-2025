package com.vodapally.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Author@ Siri-Raghu
 * Date@ 24-Oct-2014
 */
/*
LinkedHashMap is a combination of Hash table and linked list implementation of the Map interface, with predictable iteration order.
It maintains a doubly-linked list running through all of its entries.
The iteration order is normally the order in which keys were inserted into the map ie insertion order.
The insertion order is not affected if a key is re-inserted into the map.
*/

public class LinkedHashMapEx {

	public static void main(String[] args) {
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		lhm.put("one", "one element");
		lhm.put("two", "two element");
		lhm.put("three", "three element");
		lhm.put("four", "four element");
		
		System.out.println("Printing LHM directly : \n" + lhm);
		
		Set<String> keys = lhm.keySet();
		
		System.out.println("\nGet only keys : ");
		System.out.println(keys);
		
		// print using for each loop
		System.out.println("\nprint using for each loop\n");
		
		for(String k : keys){
			System.out.println( k + "--"+lhm.get(k));
		}
		
		//iterate using while loop (keySet)
		System.out.println("\nIterate using while loop");
		Iterator<String> i = keys.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
			
		}
		
		
	}

}

