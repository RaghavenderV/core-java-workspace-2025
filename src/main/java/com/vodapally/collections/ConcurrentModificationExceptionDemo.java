package com.vodapally.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

//https://www.journaldev.com/378/java-util-concurrentmodificationexception
public class ConcurrentModificationExceptionDemo {

	public static void main(String[] args) {
		//List<String> list = new ArrayList<>(); //uncomment and test
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String value = iterator.next();
			System.out.println("List value: "+value);
			
			if(value.equals("3")) {
				list.remove(value);
			}
		}
		System.out.println(list);
		
		
		//Map<String, String> map = new HashMap<>();
		Map<String, String> map = new ConcurrentHashMap<>();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			System.out.println("Map value: "+map.get(key));
			if(key.equals("2")) {
				//map.put("1", "four");
				map.put("4", "four");
			}
		}
		
		System.out.println(map);

	}

}
