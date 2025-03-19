package com.vodapally.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UnmodifiableCollection {

	/**
	 * @author Raghavender. V
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("This");
		list.add("is");
		list.add("unmodifiable collection");

		System.out.println("Element added to list at 3rd position:  " + list.get(2));

		Collection<String> immutableCol = Collections
				.unmodifiableCollection(list);

		immutableCol.add("Something added..");
		
		System.out.println(immutableCol);
		
		/*Iterator<String> iterator = immutableCol.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
	}

}
