package com.vodapally.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicatewordsinString {

	public static void main(String[] args) {
		String str = "Hyderabad is Hyderabad and hamara Hyderabad and";
		String[] strings = str.split(" ");
		List<String> list = Arrays.asList(strings);
		
		//print duplicate words in string
		Set<String> set = new HashSet<>();
		Set<String> collect = list.stream().filter(s -> !set.add(s)).collect(Collectors.toSet());
		collect.forEach(System.out::println);
		
		//count duplicate occurances in string
		 System.out.println("\nduplicate occurances in string : "+str);
		 
		 list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.filter(entry -> entry.getValue()>1)
		.forEach(System.out::println);
		
		

	}

}
