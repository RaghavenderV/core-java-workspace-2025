package com.vodapally.java8;

import java.util.stream.IntStream;

public class IntStreamAndAnyMatchExample {

	public static void main(String[] args) {
		int num[] = {10,20,30,40,50,60};
		int key = 50; //key to be searched
		
		boolean result = IntStream.of(num).anyMatch(x -> x==key);
		if(result)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
