package com.vodapally.java8;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/stream-generate-method-java/?ref=rp
public class StreamExamples {

	public static void main(String[] args) {
		
		Stream.generate(new Random()::nextInt) 
	    .limit(5).forEach(System.out::println);
		
		//https://www.geeksforgeeks.org/difference-between-stream-of-and-arrays-stream-method-in-java/
		// Stream.of() Vs Arrays.stream()
		System.out.println("\nStream.of() Vs Arrays.stream()");
		
		// 1. Different return types
		int arr[] = { 1, 2, 3, 4, 5 };
		// Using Arrays.stream()
		System.out.println("Using Arrays.stream()");
		IntStream intStream = Arrays.stream(arr);
		intStream.forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		// Using Stream.of() -> 2. needs flattening
		System.out.println("Using Stream.of()");
		Stream<int[]> stream = Stream.of(arr);
		IntStream intStream1 = stream.flatMapToInt(Arrays::stream);
		intStream1.forEach(i -> System.out.print(i+" "));
		System.out.println("\n");
		
		// 3. Stream.of is generic whereas Arrays.stream() is not
		//Arrays.stream() method works only for primitive arrays of int[], long[], and double[] type, and returns IntStream, LongStream and DoubleStream respectively. 
		//For other primitive types, Arrays.stream() won�t work.
		char charArr[] = { '5', '9', '1', '4', '3' }; 
		//Arrays.stream(charArr); //-> compilation error
		Stream<char[]> charArrayStream = Stream.of(charArr);
		charArrayStream.forEach(System.out::println);
		
		
		//
		
		
		
	}

}
