package com.vodapally.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Author@ Raghavender Vodapally
* Date@ Jun 18, 2018
*/
//This is another way to sort HashMap by keys
public class SortHashMapByKeys {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("Sachin", 215);
		hm.put("Virat", 51);
		hm.put("Yuvaraj", 69);
		hm.put("Harbhajan", 12);
		hm.put("Gambhir", 59);
		
		ArrayList<String> keysList = new ArrayList<>(hm.keySet());
		
		Collections.sort(keysList);

		for (String key : keysList) {
			System.out.println(key+":"+hm.get(key));
		}
		
		//Using Java8
		System.out.println("Using Java8");
		HashMap<String, Integer> hm1 = new HashMap<>();
		hm1.put("Sachin", 215);
		hm1.put("Virat", 51);
		hm1.put("Yuvaraj", 69);
		hm1.put("Harbhajan", 12);
		hm1.put("Gambhir", 59);
		
		Map<String, Integer> sortedMap = hm1.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
										(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(sortedMap);
	}

}

