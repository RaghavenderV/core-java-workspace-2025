package com.vodapally.practice2024;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

	public static void main(String[] args) {

		// creating a stream of strings
		Stream<String> stream = Stream.of("Java", "Spring", "Hibernate", "Microservices", "Kafka");
		//stream.forEach(System.out::println);
		
		boolean result = stream.noneMatch(str -> str.equals("Blue Prism"));
		System.out.println(result); // true
		
		/***********************************************************/
		
		//IntStream demo
		//IntStream intStream = IntStream.of(10,99,23,1,100);
		//int i = intStream.min().getAsInt();
		//System.out.println("min : "+i);
		
		// above code in one line
		System.out.println("min : "+IntStream.of(10,99,23,1,100).min().getAsInt()); // min : 1
		
		System.out.println("***********************************************************");
		
		IntStream stream2 = IntStream.of(26,15,1,99,58,100);
		
		//sorting -> printing each value
		System.out.println("Filter even numbers and sort then print");
		IntStream stream3 = IntStream.of(26,15,1,99,58,100);
		
		//filter even numbers -> sorting -> printing each value
		stream3.filter(num -> (num%2 == 0))
			   .sorted().forEach(System.out::println);

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		Stream<Integer> partitionStream = Stream.of(26,15,1,99,58,100);
		Map<Boolean, List<Integer>> evenOddPartition = partitionStream.collect(
																Collectors.partitioningBy(n -> (n % 2 == 0)));
		System.out.println("Even Numbers ->");
		evenOddPartition.get(true).forEach(even -> System.out.print(even+" "));
		System.out.println("\nOdd Numbers ->");
		evenOddPartition.get(false).forEach(odd -> System.out.print(odd+" "));

		System.out.println("\n************************END***********************************");
		System.out.println("sorting in reverse order after odd numbers out i/p : 26,15,1,99,58,100\n");
		
		//filtering odd numbers -> boxing(converting to Integer) -> converted to List<Integer> 
		//-> streaming -> sorting in reverse order -> printing each value
		IntStream stream4 = IntStream.of(26,15,1,99,58,100);
		stream4.filter(num -> !(num%2 == 0))
			   .boxed()//converting to Integer
			   .collect(Collectors.toList())
			   .stream()
			   .sorted(Comparator.reverseOrder())
			   .forEach(e -> System.out.print(e+" "));  // 99 15 1
		
		
		
		System.out.println("\n***********************************************************");

		//isPrime or not -> prime divides by 1 and itself only; if divides by 2 -> not prime
		int i = 7;

		boolean isPrime = IntStream.range(2, i).noneMatch(num -> num % 2 == 0);

		System.out.println("is 7 Prime number? " + isPrime);
		
		
		System.out.println("***********************************************************");
		
		//limit method
		Random random = new Random();
		random.ints(1,100).limit(10).sorted().forEach(System.out::println);
		
		//Convert list of strings to upper case
		System.out.println("\n***********************************************************");
		List<String> brands = Arrays.asList("Samsung","Apple","Infinix","Motorola");

		//sort in ascending order
		brands.stream().map(String::toUpperCase)
					.sorted()
					   .collect(Collectors.toList())
					   .forEach(System.out::println);

		System.out.println("\n***********************************************************");
		List<Integer> intList = Arrays.asList(1,2,9,4,2,1,9,9,9);
		
		//frequency duplicates
		//intList.stream().distinct().forEach(System.out::println);
		//frequency of duplicates
		Map<Integer,Long> map = intList.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		map.forEach((k,v) -> System.out.println(k+" repeated -> "+v +" times."));
		
		
		
		System.out.println("\n***********************************************************");
		
		//Sum of integers in a list - method-1
		List<Integer> numList = Arrays.asList(1,2,9,4,2,1,9,9,9);
		
		int sum = numList.stream()
				 .mapToInt(Integer :: intValue)//convert Integer to int
				 .sum();
		
		//method-2 with method ref
//		int sum = numList.stream()
//						 .mapToInt(e -> e.intValue())//convert Integer to int
//						 .sum();
		
		System.out.println("Sum : "+sum);//Sum : 46
		
		
		System.out.println("\n***********************************************************");
		
		//Check if all elements in a list satisfy a given condition
		
		List<Integer> evenList = Arrays.asList(2,9,6,8,10);
		
		boolean isEven = evenList.stream().allMatch(e -> (e%2==0));
		if(isEven)
			System.out.println("All elements in list are Even");
		
	}

}
