package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> numberGreaterThan5 = x -> x>5;
		Predicate<Integer> numberLessThan8 = x -> x<8;

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		// get list of integers which are greater than 5 and less than 8
		List<Integer> collect = list.stream().filter(numberGreaterThan5.and(numberLessThan8))
		.collect(Collectors.toList());
		
		collect.forEach(System.out::println);
		
	}

}
