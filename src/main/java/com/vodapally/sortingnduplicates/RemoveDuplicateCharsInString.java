package com.abhi.sortingnduplicates;

import java.util.LinkedHashSet;

/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 12, 2017
 */


public class RemoveDuplicateCharsInString {

	public static void main(String[] args) {
		
		String input = "raghuraghu.v";
		
		removeDuplicateCharsUsingSet(input);
		
		System.out.println();
		
		String input1 = "abhiabhi";
		
		withOutUsingCollections(input1);
		

	}
	
	private static void withOutUsingCollections(String input) {
		String result = "";
		
		for(int i=0; i<input.length(); i++){
			if(!result.contains(String.valueOf(input.charAt(i)))){ //String.valueOf() method returns the string representation of the passed argument.
				result += input.charAt(i);
			}
			
		}
			
		System.out.println(result);
	}

	private static void removeDuplicateCharsUsingSet(String s){
		LinkedHashSet<Character> lhs = new LinkedHashSet<>(); //it does not allow duplicates and maintains insrtion order
		
		for(int i=0; i<s.length(); i++){
			lhs.add(s.charAt(i));
		}
		
		//print string after deleting duplicate chars
		for(Character ch:lhs){
			System.out.print(ch);
		}
		
	}

}

