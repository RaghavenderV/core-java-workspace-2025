package com.vodapally.java8;

import java.util.stream.IntStream;

public class FindPalindromesInString {

	public static void main(String[] args) {
		String str = "my name nitin and I can speak malayalam";
		String[] words = str.split(" ");
		System.out.println(str);
		System.out.println("\nPalindrome strings are: ");
		
		for (int i = 0; i < words.length; i++) {
			 if(isPalindrome(words[i])) {
				 System.out.println(words[i]);
			 }
			
		}
		
		System.out.println("\n******************************************");
		String s = "ROTATOR";
		System.out.println("s.length()/2 -> "+s.length()/2+ "; charAt : "+s.charAt(3));
		if(isPalindromeUsingStream(s))
				System.out.println(s+" is a PALINDROME");
		else 
			System.out.println(s+" is NOT PALINDROME");

	}
	
	public static boolean isPalindrome(String input) {
		int i1 = 0;
		int i2 = input.length()-1;
		
		while(i2>i1) {
			if(input.charAt(i1)!=input.charAt(i2)) {
				return false;
			}
			i1++;
			i2--;
		}
		
		return true;
	}
	
	public static boolean isPalindromeUsingStream(String s) { // ROTATOR
		
		
		//without using reverse() method
		boolean isItPalindrome = IntStream.range(0, s.length()/2) // take half length of the string
					.noneMatch(i -> s.charAt(i) != s.charAt(s.length()-i-1));//1st iteration-> R!=R -> true 
																			//2nd-> O!=O -> true
																			//3rd-> T!=T -> true
					
					
		return isItPalindrome;
	}

}
