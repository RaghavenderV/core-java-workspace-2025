package com.vodapally.java8;

import java.util.Arrays;
//https://javaconceptoftheday.com/differences-between-iterator-vs-spliterator-in-java-8/
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterator.OfInt;
import java.util.function.IntConsumer;

public class SpliteratorExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Skype", "Facebook", "Instagram", "Twitter"); 
		//getting spliterator object
		Spliterator<String> namesSpliterator = names.spliterator();
		
		//use tryAdvance(){combination of hasNext() and next() in Iterator} to display(action) of elements.
		System.out.println("Next element present? "+namesSpliterator.tryAdvance(System.out::println));
		System.out.println("Next element present? "+namesSpliterator.tryAdvance(System.out::println));
		
		System.out.println("remaining names present in the list");
		namesSpliterator.forEachRemaining(System.out::println);
		
		//act on array elements
		int[] scores = {56,124,36,59};
		OfInt scoresSpliterator = Arrays.spliterator(scores);//returns of type- Spliterator.OfInt
		System.out.println("Elements of Array: ");
		scoresSpliterator.forEachRemaining((IntConsumer)System.out::println);
		
		System.out.println("Other way to print array");
		Arrays.stream(scores).forEach(System.out::println);
		
		
		

	}

}
