package com.vodapally.practice2024;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordInString {

	public static void main(String[] args) {
		
		String input = "Hello India";
		
		String[] words = input.split(" ");

		String reverse = Stream.of(words).map(word -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println(input+"--> reverse -> "+reverse);  // olleH aidnI
		

	}

}
