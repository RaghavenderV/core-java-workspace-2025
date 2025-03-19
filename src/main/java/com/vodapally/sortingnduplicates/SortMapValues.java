package com.vodapally.sortingnduplicates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortMapValues {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("raghu", 32);
		map.put("siri", 26);
		map.put("ravi", 29);
		map.put("padma", 50);
		map.put("bapu", 56);
		map.put("abhi", 1);
		
		System.out.println("Before sorting: "+ map);
		
		System.out.println("-------- Java8 --------");
		Map<String, Integer> sortedMapByValues = map.entrySet()
			.stream()
			.sorted(Entry.comparingByValue())
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
		
		sortedMapByValues.forEach((name, age) -> System.out.println(name+" "+age));
		
		System.out.println("-------- Java8 --------");
		
		// sorting map by values - another approach
		List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet()); // as Collections.sort() require List
		
		Collections.sort(list, (obj1, obj2) -> (obj1.getValue() - (obj2.getValue())));
		
		System.out.println("After sorting by values: ");
		
		for(Entry<String, Integer> entry: list){
			System.out.println(entry.getKey() +"  -- "+entry.getValue());
		}
		
		//sort map by keys; as TreeMap sorts the map in ascending order; just pass map object
		System.out.println("\nSORT BY KEYS");
		TreeMap<String, Integer> sortByKeys = new TreeMap<>(map);
		
		//Using java 8
		sortByKeys.forEach((name, age) -> System.out.println(name+" "+age));
		
		/*for(String s: sortByKeys.keySet()){
			System.out.println(s+" : "+sortByKeys.get(s));
		}*/

	}

}
