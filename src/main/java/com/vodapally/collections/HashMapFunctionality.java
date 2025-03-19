package com.vodapally.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapFunctionality {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// insertion order is not preserved
		HashMap hm = new HashMap();
		
		hm.put("malli", new Double(459));
		hm.put("raghu", new Double(999));
		hm.put("cnu", new Double(357));
		hm.put("cnu", "Key Overridden"); //key is unique; overrides the previous one
		hm.put("john1", null);
		//hm.put(null, new Integer(143));
		//hm.put(null, "Null key overridden"); // overrides the previous one
		//hm.put(null, null);  //commented to display only keySet values
		
		System.out.println("Printing Hashmap directly..");
		System.out.println(hm);

		// iterating hash map using iterator()
		
		Set set = hm.entrySet();
		Iterator i = set.iterator();
		
		System.out.println("What I'm getting for set here : "+set);
		
		System.out.println("\n\nDisplay using Iterator..");
		
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.println("Key = " + me.getKey() + " ; Value = " + me.getValue());
		}// while

		/*
		 To obtain only keys
		 While iterating over keySet(), keys should not be null(raises NullPointerException); 
		*/
		//Comment the null entry keys and run below code
		
		
		 System.out.println("\nDispalying only keys of the Hashmap :");
		 Set set1=hm.keySet(); 
		 Iterator i1=set1.iterator();
		 
		 while(i1.hasNext()){ 
			 /*Object obj=i1.next();
			 System.out.println("key : "+obj.toString()); */
			
			 String str = (String)i1.next();
			 System.out.println("Key : " + str);
			 
			}  
		
		 
		 /*
		   To obtain only values 
		   While iterating over values, values should not be null(raises NullPointerException); 
		 */
		 
		 // Comment the null entry values and run below code 
		 
		 /*
		 Collection collection=hm.values(); 
		 Iterator i2=collection.iterator(); 
		 while(i2.hasNext()){ 
			 Object obj2=i2.next();
		 System.out.println("values : "+obj2.toString()); 
		 }
		 */
	}
}
/*
 * HashMap : some methods -> clear, containsKey,containsValue, entrySet, put,get,
 *  isEmpty, keySet, putAll, remove, size, values.
  
  The underlying data structure is HashTable.
  Duplicate keys are not allowed, but values are allowed
  Insertion Order is not Preserved, its based on hash code of keys
  Heterogeneous objects are allowed for both keys and values
  null key is allowed only once null values are allowed multiple times
 */