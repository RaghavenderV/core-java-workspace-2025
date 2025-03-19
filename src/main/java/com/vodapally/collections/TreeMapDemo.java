package com.vodapally.collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {

	/**
	 * @author Raghavender. V
	 */
	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();

		treeMap.put("1", "one");
		treeMap.put("2", "one"); // values can be duplicate
		treeMap.put("5", "five");
		treeMap.put("3", "three");
		treeMap.put("3", "over-ridden"); // duplicate keys are not allowed, if have, overrides the previous
		treeMap.put("6", null); // null values are possible
		treeMap.put("9", null); // null values are possible

		//treeMap.put(null, "Exception"); // null keys are not allowed, raises NullPointerException
		System.out.println("Tree Map : " + treeMap);

		SortedMap<String, String> sortedMap = treeMap.tailMap("5");
		System.out.println("Tail Map Contains : " + sortedMap);

	}

}
