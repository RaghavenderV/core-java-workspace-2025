package com.abhi.sortingnduplicates;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveDupicateValuesFromMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); //if the value is duplicate, remove that entry
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "1");
		map.put("E", "1");
		map.put("F", "2");
		
		System.out.println("Original Map : "+map);
		
		for(String key : new HashMap<String, String>(map).keySet()) {
			String value = map.get(key);
			
			for(Entry<String, String> mapEntry : new HashMap<String, String>(map).entrySet()) {
				if(key!=mapEntry.getKey() && value == mapEntry.getValue()) {
					System.out.println("Removed element: "+mapEntry.getKey());
					map.remove(mapEntry.getKey());
				}
			}
			
		}
		
		System.out.println("Final Map : "+map);
		
	}
}
/*
 
 Set keySet( )
Returns a Set that contains the keys in the invoking map. This method provides a set-view of the keys in the invoking map.

Set entrySet( )
Returns a Set that contains the entries in the map. The set contains objects of type Map.Entry. 
This method provides a set-view of the invoking map.

The Map.Entry interface enables you to work with a map entry.
The entrySet( ) method declared by the Map interface returns a Set containing the map entries. 
Each of these set elements is a Map.Entry object.
 */
