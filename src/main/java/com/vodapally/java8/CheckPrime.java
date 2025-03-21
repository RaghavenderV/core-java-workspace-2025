package com.vodapally.java8;
//https://www.geeksforgeeks.org/intstream-range-java/

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CheckPrime {

    public static void main(String[] args) {
        int num = 19;

        if (isPrime(num))
            System.out.println("Given " + num + " is Prime");
        else {
            System.out.println("Given " + num + " is Not Prime");
        }

        printAllPrimeNumbers();
        long count = printCountOfPrimeNumbers();
        System.out.println("Prime numbers in 100 are : " + count);


    }

    private static long printCountOfPrimeNumbers() {
        long count = Stream.iterate(0, n -> n + 1)
                .limit(100)
                .filter(CheckPrime::isPrime)
                .count();

        return count;

    }

    public static void printAllPrimeNumbers() {
        Stream.iterate(0, n -> n + 1)
                .limit(100)
                .filter(CheckPrime::isPrime)
                .forEach(System.out::println);

    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number)
                .noneMatch(i -> number % i == 0);
    }

}
//IntStream range(int startInclusive, int endExclusive) returns a sequential ordered IntStream from startInclusive (inclusive) 
//to endExclusive (exclusive) by an incremental step of 1
//IntStream.range -> displaying the elements in range including the lower bound and excluding upper bound
