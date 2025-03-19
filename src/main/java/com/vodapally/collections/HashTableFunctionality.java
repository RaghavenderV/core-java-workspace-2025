package com.vodapally.collections;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableFunctionality {

	/**
	 * @author Raghavender V.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Hashtable ht=new Hashtable();
		
		ht.put("raghu", "java");
		ht.put("raghu", "how r u "); // overrides previous one
		ht.put("raghu","who r u" );
		
		System.out.println("reached1");
		
		//ht.put(null, "hi");        // raises RuntimeException--NullPointerException--null keys or null values not allowed
		//ht.put("NotAccepted", null); // raises RuntimeException--NullPointerException 
		System.out.println("reached2");
		ht.put("suresh", "hello");
		ht.put("ram", "hello");//Values can be duplicates
		
		System.out.println("Displaying Hashtable directly..");
		System.out.println(ht);
		
		//Iterating through Iterator
		System.out.println("\nDisplaying Hashtable using iterator() and entrySet()..");
		Set<Map.Entry> set = ht.entrySet();
		Iterator i=set.iterator();
		while(i.hasNext()){			
			Map.Entry me=(Map.Entry)i.next();
			System.out.println("key="+me.getKey()+" ; value="+me.getValue());
		}
		
		System.out.println("\n\nIteration using enumeraion:");
		Enumeration keys = ht.keys();
		while(keys.hasMoreElements()){
			//System.out.println(e.nextElement()); // display only keys
			String key = (String)keys.nextElement();
			System.out.println("key: "+key + "  value: "+ht.get(key));
		}
		

	}

}
/*
Hashtable doesn't allow any null key or value.
*/