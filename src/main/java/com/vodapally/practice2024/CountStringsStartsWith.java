package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountStringsStartsWith {

	public static void main(String[] args) {
		
	  //Given a list of strings, write a program to count the no.of strings that starts with specific character
		
		List<String> nameList = Arrays.asList("raghu","rani", "ravi","shirisha","siri","haneesh");

		long count = nameList.stream()
							.filter(name -> name.startsWith("s"))
							.count();
		System.out.println("Count : "+count);
		
		
		System.out.println("\n*******************************");
		//concatenate all strings with ","
		List<String> list = Arrays.asList("raghu","rani", "ravi","shirisha","siri","haneesh");
		
		String str = list.stream().collect(Collectors.joining(","));
		System.out.println(str);
		
		
		System.out.println("\n*******************************");
		List<String> strList = Arrays.asList("raghu","ritu", "ruthvik","shirisha","siri","haneesh");

		System.out.println("\ngroup them by their first letter, and then count the no.of names in each group");
		strList.stream().collect(Collectors.groupingBy(str2 -> str2.charAt(0), Collectors.counting()))
				.forEach((k,v) -> System.out.println(k + " -> "+v));
		
		
		

	}

}
