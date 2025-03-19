package com.vodapally.practice;

public class SubstringInString {

	public static void main(String[] args) {
		String str1 = "champion";
		String str2 = "ion";

		isItSubstringOfString(str1, str2);
	}

	static void isItSubstringOfString(String str1, String str2) {
		if (str1.contains(str2))
			System.out.println(str2 + " is a SUBSTRING of " + str1);
		else if (str1.contains(reverseOfSubstring(str2)))
			System.out.println(str2 + " is a SUBSTRING of " + str1);
		else
			System.out.println(str2 + " is NOT A SUBSTRING of " + str1);

	}

	static String reverseOfSubstring(String str2) {
		StringBuffer sb = new StringBuffer(str2);
		return sb.reverse().toString();
	}

}
/*
 * Suppose there are 2 strings source =�abcde� target =�ab� . Your program
 * should return true if target is there in source.And also if the reverse of
 * target is there in source soruce="abcde� targ="ab" revtarg="ba
 */