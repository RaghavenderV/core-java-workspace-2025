package com.vodapally.java8;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		String string = "Hello World Hey"; //W
		
		//Find First Non-Repeated Character
		 Character character = string.chars() //convert String into IntStream
										.mapToObj(s -> Character.toLowerCase(Character.valueOf((char)s))) //Convert IntStream into Stream<Character> 
										.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // //Store the chars in map with count
										// Function.identity() returns a Function that always returns it�s input argument
										.entrySet()
										.stream()
										.filter(entry -> entry.getValue()==1L)
										.map(Entry::getKey)
										.findFirst()
										.get();
		 
		 System.out.println("FirstNonRepeatedCharacter : "+character);
		 
		//Find First Repeated/Duplicate Character
		 Character ch = string.chars()
		.mapToObj(s -> Character.toLowerCase(Character.valueOf((char)s))) //First convert to Character object and then to lowercase 
		.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // //Store the chars in map with count 
		.entrySet()
		.stream()
		.filter(entry -> entry.getValue()>1L)
		.map(entry -> entry.getKey())
		.findFirst()
		.get();
		 
		 System.out.println("First Repeated Character : "+ch);
		
		
	}

}
