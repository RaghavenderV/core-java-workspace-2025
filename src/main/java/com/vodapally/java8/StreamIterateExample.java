package com.vodapally.java8;

import java.util.stream.Stream;

public class StreamIterateExample {

	public static void main(String[] args) {
		// 1. Stream.iterate(initial value, next value)
		Stream.iterate(0, n->n+1)
				.limit(10)
				.forEach(System.out::println);
		
		System.out.println("Odd numbers");
		
		//2. print oddnumbers
		Stream.iterate(0, n->n+1)
				.filter(x ->!(x%2==0))
				.limit(10)
				.forEach(System.out::println);
				
		

	}

}
