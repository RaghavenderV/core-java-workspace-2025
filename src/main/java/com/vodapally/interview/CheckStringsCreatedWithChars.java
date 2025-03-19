package com.vodapally.interview;

import java.util.Set;
import java.util.stream.Collectors;

public class CheckStringsCreatedWithChars {

	public static void main(String[] args) {
		sameCharsStrings("abc", "cba");
		sameCharsStrings("aabbcc", "abc");
		sameCharsStrings("abcd", "abc");
		sameCharsStrings("11", "1122");
		sameCharsStrings("11", "11");	

	}

	public static void sameCharsStrings(String s1, String s2) {
		Set<Character> set1 = s1.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
		Set<Character> set2 = s2.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
		
		System.out.println(set1.equals(set2));
		
	}

}
