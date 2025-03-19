package com.vodapally.sortingnduplicates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("tiger");
		list.add("lion");
		list.add("lion");
		list.add("tiger");
		list.add("rhino");

		System.out.println("Original List : " + list);

		List<String> nonDuplicateList = new ArrayList<>();
		
		
		System.out.println("-------Using Java8 : ------------");
		list.stream().distinct().forEach(System.out::println);
		System.out.println("-------Using Java8 : ------------");
		
		
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			String item = i.next();
			if(!nonDuplicateList.contains(item)) {
				nonDuplicateList.add(item);
			}
		}

		System.out.println("After Removing Duplicates : " + nonDuplicateList);
		
		
		//another way to remove duplicates ; without creating another list; without adding to set; best way
		System.out.println("---------------------------------------");
		System.out.println("another way to remove duplicates");
		List<String> l = new ArrayList<>();

		l.add("tiger");
		l.add("lion");
		l.add("lion");
		l.add("tiger");
		l.add("rhino");

		System.out.println("Original List : " + l);
		
		Object[] objectArray = l.toArray();
		
		for(Object obj: objectArray) {
			if(l.indexOf(obj)!=l.lastIndexOf(obj)) {
				l.remove(obj);
			}
		}
		
		System.out.println("List after removing duplicates : "+l);

	}

}
