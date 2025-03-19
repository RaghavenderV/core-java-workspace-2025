package com.vodapally.logics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterEvenNumbers {

	public static void main(String[] args) {
		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		
		Stream<Integer> streamOfNumbers = Arrays.stream(numbers);

		List<Integer> list = streamOfNumbers.filter(n -> n%2==0).collect(Collectors.toList());
		list.forEach(System.out::println);
	}

}
