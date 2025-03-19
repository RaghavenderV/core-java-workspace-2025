package com.vodapally.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapIterations {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Telugu", 89);
		map.put("English", 75);
		map.put("Mathematics", 68);
		map.put("Physics", 56);
		map.put("Computers", 92);
		
		System.out.println("Map Iterations :\n");
		System.out.println("Using SOP : "+ map);
		
		System.out.println("\nUsing for-each, entrySet() \n");
		
		for(Entry<String, Integer> me : map.entrySet()){
			System.out.println("Key: "+me.getKey() + "  Value: " + me.getValue());
		}
		
		System.out.println("\nUsing Iterator and while loop\n");
		
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()){
			//System.out.println(it.next()); // This prints key value pair directly
			//below code is to get keys and values separately
			Entry<String, Integer> me = (Entry<String, Integer>)it.next();
			System.out.println("Key:"+me.getKey()+ ",  Value: "+me.getValue());
		}
		
		System.out.println("\nGetting map keys");
		System.out.println(map.keySet());
		
		System.out.println("\nGetting map keys and values using for-each");
		for(String s: map.keySet()){
			System.out.println("Key: "+s+"  Value: "+map.get(s));
		}
		
		System.out.println("\nGetting map values");
		System.out.println(map.values());
		
		System.out.println("\nMap value as user object");
		
		Map<String, MapValue> userMap  = new HashMap<String, MapValue>();
		userMap.put("Raghu", new MapValue(101, "Tupran", 29));
		userMap.put("Abhinav", new MapValue(102, "Hyderabad", 36));
		userMap.put("Mounika", new MapValue(103, "Kamareddy", 35));
		userMap.put("Shirisha", new MapValue(104, "Bangalore", 24));
		userMap.put("Padma", new MapValue(105, "Gajwel", 21));
		
		System.out.println("\n"+userMap);
		
		for(Entry<String, MapValue> me1 : userMap.entrySet()){
			System.out.println("Key: "+me1.getKey() + ",  Value: " + me1.getValue());
		}
		
	}
}

class MapValue{
	private int id;
	private String address;
	private  int age;
	
	public MapValue(int id, String address, int age){
		this.id = id;
		this.address = address;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("id: "+id+" age: "+age+" address: "+address);
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
