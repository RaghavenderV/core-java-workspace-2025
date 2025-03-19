package com.abhi.sortingnduplicates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
* Author@ Raghavender Vodapally
* Date@ Nov 8, 2017
*/

class ComparatorImpl implements Comparator<Integer>{
	@Override
	public int compare(Integer obj1, Integer obj2) {
		
		if(obj1%10 > obj2%10)
			return 1;
		
		return -1;
	}
	
}

public class SortingWithIntLastDigit {

	public static void main(String[] args) {
		
		List<Integer> values = new ArrayList<>();
		values.add(128);
		values.add(324);
		values.add(651);
		values.add(696);
		values.add(599);
		
		Comparator<Integer> myLogic = new ComparatorImpl();
		
		Collections.sort(values, myLogic);
		
		System.out.println(values);//[651, 324, 696, 128, 599] - sorted using last digit - 1,4,...

	}

}

