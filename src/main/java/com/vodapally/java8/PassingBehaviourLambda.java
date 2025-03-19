package com.vodapally.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PassingBehaviourLambda {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}

		int sumOf10 = sumWithCondition(list, i -> true);// passing behavior
		System.out.println("Sum Of 1-10 is : " + sumOf10);

		int evensSum = sumWithCondition(list, i -> i % 2 == 0);
		System.out.println("Evens Sum in 1-10 is :" + evensSum);

		int oddsSum = sumWithCondition(list, i -> i % 2 != 0);
		System.out.println("Odds Sum in 1-10 is :" + oddsSum);

	}

	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
		return numbers.parallelStream().filter(predicate).mapToInt(i -> i).sum();
	}

}
