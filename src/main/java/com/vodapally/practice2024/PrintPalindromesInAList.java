package com.vodapally.practice2024;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintPalindromesInAList {

	public static void main(String[] args) {

		List<String> strings = List.of("radar","toopran","deed","konthanpally","malayalam","madam");
		
		List<String> palindromes = strings.stream()
											.filter(str -> str.contentEquals(new StringBuilder(str).reverse()))
											.sorted()
											.toList();
		
		palindromes.forEach(System.out::println);


		// String reverse using streams
		String s  = "BENGALURU";
		String str = reverseString(s);
		System.out.println("\n"+s+"-->"+str);

	}

	private static String reverseString(String str) {
		return IntStream.range(0,str.length())
				.mapToObj(i -> str.charAt(str.length()-i-1))
				.map(String::valueOf)
				.collect(Collectors.joining());
	}

}
