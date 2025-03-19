package com.vodapally.collections;

import java.util.HashSet;

public class HashsetRetainsElements {

	public static void main(String[] args) {
		
		// Display the common elements in Hashset
		HashSet<String> hashSet=new HashSet<String>();
		hashSet.add("hp");
		hashSet.add("dell");
		hashSet.add("acer");
		hashSet.add("lenovo");
		
		HashSet<String> hashSet1=new HashSet<String>();
		hashSet1.add("hp");
		hashSet1.add("apple");
		hashSet1.add("dell");
		hashSet1.add("iball");
		
		hashSet.retainAll(hashSet1);  //hashSet contains : hp and dell
		
		HashSet<String> hashSet2=new HashSet<String>();
		hashSet2.add("hp");
		hashSet2.add("dell");
		hashSet2.add("intel");
		hashSet2.add("toshiba");
		
		hashSet1.retainAll(hashSet2);  //hashSet1 contains hp and dell
		
		
		System.out.println(hashSet1);
		
		//HashSet<String> intersect=new HashSet<String>0();

	}

}
