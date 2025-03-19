package com.vodapally.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicatesInIntArray {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,10,10,20,30,55,55,60,60);
		Set<Integer> set = new LinkedHashSet<>();
		list.stream().filter( x ->!set.add(x)).collect(Collectors.toSet())
		.forEach(System.out::println);

	}

}