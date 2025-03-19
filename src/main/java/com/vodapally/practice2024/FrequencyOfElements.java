package com.vodapally.practice2024;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyOfElements {

	public static void main(String[] args) {

		String input ="hello!  hyderabad!! shhh!";
		IntStream intStream = input.chars();
		Map<Character, Long> map = intStream.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);

		System.out.println("\nFind Duplicates and its occurrence:\n");
		findDuplicatesAndOccurrence(input);
		
		// count each word frequency - method-1
		System.out.println("************************************");
		String s = "hello india india is my country i love love india";
		System.out.println(s);
		
		String[] strings = s.split(" ");
		
		//Stream<String> stream = Stream.of(strings);//method-1
		
		Stream<String> stream = Arrays.stream(strings); //method-2
		
		stream.collect(Collectors.groupingBy(
					  Function.identity(), Collectors.counting()
					  ))
			  .forEach((w,c) -> System.out.println(w+" : "+c));
		
		
		
		System.out.println("\n************************************"); //methood-2
		String str = "hello India indIa is my country i LOVE love INdia";
		System.out.println(str);
		
		String[] s2 = str.split(" ");
		
		Arrays.stream(s2)
			  .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
			  .forEach((w,c) -> System.out.println(w+" : "+c));



		System.out.println("\nfrequency of element in array");
		Integer[] intArray = {1,4,3,1,4,3,1,1,1,9};
		String[] strArray = {"tomato", "beans","tomato","tomato", "potato","brinjal"};

		findFrequency(intArray);
		System.out.println("\n*****************************");
		findFrequency(strArray);

		findHighestFrequency(strArray);

	}

	private static void findDuplicatesAndOccurrence(String input) {
		input.chars().mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue()>1)
				.forEach(System.out::println);
	}

	private static <T> void findFrequency(T[] array) {
		Map<T, Long> map = Stream.of(array)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		map.forEach((k, v) -> System.out.println(k + " : "+v));
	}

	private static <T> void findHighestFrequency(T[] array) {
		Map.Entry<T, Long> entry = Stream.of(array)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.get();


		System.out.println("***************************************");
		System.out.println("\nMax element and occurrence --> "+entry.getKey()+" : "+entry.getValue());
	}

}
