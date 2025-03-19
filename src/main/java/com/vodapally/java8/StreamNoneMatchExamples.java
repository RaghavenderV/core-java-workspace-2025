package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamNoneMatchExamples {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("CSE", "C++", "Java", "DS");
		
		boolean result = stream.noneMatch(str -> (str.length()==4));
		System.out.println(result);

		List<Integer> list = Arrays.asList(4, 0, 6, 2);
		boolean ans = list.stream().noneMatch((num -> num<0));
		System.out.println(ans);
		
		Stream<String> techStream = Stream.of("CSE", "C++", "Java", "DS");
		boolean anyMatch = techStream.anyMatch(str->str.equals("Java"));
		System.out.println("anyMatch() -> "+anyMatch);
		
	}

}
