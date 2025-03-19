package com.vodapally.java8;

import java.util.HashMap;
import java.util.Map;
//https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
public class IsomorphicString {

	public static void main(String[] args) {
		String s1 = "paper";
		String s2 = "title"; //s1 and s2 are isomorphic

		String s3 = "egg";
		String s4 = "add"; //isomorphic


		if(isIsomorphic(s1, s2)) {
			System.out.println(s1+" and "+s2+" are isomorphic strings");
		}
		else {
			System.out.println("not isomorphic strings..");
		}

	}

	public static boolean isIsomorphic(String s1, String s2) {
		Map<Character, Character> map = new HashMap<>();

		if(s1.length()!=s2.length())
			return false;

		for(int i=0;i<s1.length(); i++) {
			if(map.containsKey(s1.charAt(i))) {
				if(map.get(s1.charAt(i))!=s2.charAt(i)) {
					return false;
				}
			}
			else {//first time for each character iin string else part executes
				map.put(s1.charAt(i), s2.charAt(i));
			}
		}
		return true;

	}

}
