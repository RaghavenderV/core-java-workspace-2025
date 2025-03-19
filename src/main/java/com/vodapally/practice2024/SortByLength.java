package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByLength {

	public static void main(String[] args) {
		// Given a list of strings, sort them according to increasing order of their length?
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		
		List<String> collect = listOfStrings.stream()
											.sorted(Comparator.comparing(String::length))
											.collect(Collectors.toList());
		System.out.println(collect);

	}

}
