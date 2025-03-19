package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;

public class MapReduceExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("corejava","jsp", "hibernate","springboot");
		String longestString = list.stream().reduce((word1, word2) -> word1.length()>word2.length()?word1:word2).get();
		System.out.println(longestString);
		
		List<Integer> intList = Arrays.asList(6,9,2,1,3);
		Integer max = intList.stream().reduce(0, (a,b)-> a>b?a:b);
		System.out.println(max);

	}

}
