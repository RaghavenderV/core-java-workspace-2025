package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;

public class FindNumbersStartsWithOne {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,20,35,13,15,59);
		list.stream()
			.map(s -> s+"")//convert to string
			.filter(s -> s.startsWith("1"))
			.forEach(System.out::println);

	}

}
