package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagram {

	public static void main(String[] args) {

		String str1 = "keep";
		String str2 = "peek";

		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		if (Arrays.equals(charArray1,charArray2))
			System.out.println("keep and peek are anagrams");
		else System.out.println("keep and peek are not anagrams");

		// anagram : CarRace=RaceCar, Mug=Gum
		String s1 = "CarRace"; 
		String s2 = "RaceCar";

		// Using streams
		String[] c1 = s1.split("");
		String[] c2 = s2.split("");

		String s3 = Arrays.stream(c1).map(String::toUpperCase)
						 .sorted().collect(Collectors.joining());
		
		String s4 = Arrays.stream(c2).map(String::toUpperCase)
						 .sorted().collect(Collectors.joining());
		
		
		if(s3.equals(s4))
			System.out.println("Given Strings are ANAGRAM");
		else
			System.out.println("Given Strings are NOT ANAGRAM");
		
	}

}
