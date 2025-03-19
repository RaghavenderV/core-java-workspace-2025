package com.abhi.java8;

import java.util.Arrays;

public class ParallelSortDemo {

	public static void main(String[] args) {
		String[] fruits1 = {"guava", "apple", "banana"};
		String[] fruits2 = {"guava", "apple", "banana"};
		
		//before jdk1.8
		System.out.println("Before JDK1.8 , using Arrays.sort()");
		Arrays.sort(fruits1);
		System.out.println(Arrays.toString(fruits1));
		
		//after jdk1.8 // performance increased when it's large array
		System.out.println("After JDK1.8 , using Arrays.parallelSort()");
		Arrays.parallelSort(fruits2);
		System.out.println(Arrays.toString(fruits2));

	}

}
