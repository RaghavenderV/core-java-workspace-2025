package com.vodapally.collections;

import java.util.HashMap;
import java.util.TreeMap;


/*
* Author@ Raghavender Vodapally
* Date@ Jun 19, 2018
*/
public class SortHashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = ThirdParty.doIt();
		sortIt(hashMap);

	}

	static void sortIt(HashMap<Integer, String> hashMap) {
		System.out.println(hashMap);
		TreeMap<Integer, String> treeMap = new TreeMap<>(hashMap);
		
		System.out.println(treeMap);
	}

}

class ThirdParty{
	
	public static HashMap<Integer, String> doIt() {
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(5, "A");
		hm.put(10, "dfcd");
		hm.put(1, "dd");
		hm.put(2, "re");
		hm.put(99, "lo");
		return hm;
	}
}

