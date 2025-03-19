package com.abhi.java8;

public class FindVowelsInString {

	public static void main(String[] args) {
		String input ="hello world";
		long count = input.chars().filter(x -> {
			return(x=='a'||x=='e'||x=='i'||x=='o'||x=='u');
		}).count();
		
		System.out.println("No Of Vowels in "+input+" is : "+count);

	}

}
