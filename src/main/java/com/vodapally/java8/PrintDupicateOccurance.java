package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintDupicateOccurance {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Raghu", "Haneesh", "Raghu", "Haneesh", "Haneesh", "Abhinav");
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		map.forEach((key, count) -> System.out.println(key + " : " + count));

	}

}
