package com.vodapally.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {

		String s = "hello"; // ->output: h
		System.out.println("Original String : "+s);

		char ch = findFirstNonRepeatedCharacter(s);

		System.out.println("FirstNonRepeatedCharacter : " + ch);
	}

	static char findFirstNonRepeatedCharacter(String s) {
		char[] charArray = s.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (char ch : charArray) {
			if (!map.containsKey(ch)) // if character is not there in hashmap, then put 1.
				map.put(ch, 1);
			else
				map.put(ch, map.get(ch) + 1);
		}
		System.out.println("Occurances Map : "+map);
		
		Set<Character> charSet = map.keySet();
		char output = 0;
		for (char ch : charSet) {
			if (map.get(ch) == 1) {
				output = ch;
				break;
			}
		}
		return output;
	}

}
