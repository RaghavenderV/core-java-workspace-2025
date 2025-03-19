package com.vodapally.java8;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinaryOperatorExamples {
    public static void main(String[] args) {
        // Example-1
        BinaryOperator<Integer> bi = (a, b) -> a;
        System.out.println("a,b->a : " + bi.apply(12, 15));

        // Example-2
        BinaryOperator<Integer> maxOperator = BinaryOperator.maxBy(Comparator.naturalOrder());
        System.out.println("\nMax in 20 and 30 is : " + maxOperator.apply(20, 30));

        // Example-3 -> Sum up all integers in integer array
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer result1 = sumTotal(List.of(numbers), 0, (a, b) -> (a + b)); //BinaryOperator as argument
        System.out.println("\nSum of integers using BinaryOperator : " + result1);


        // Sum up all integers in integer array using mapToInt
        int sum = Stream.of(numbers).mapToInt(n -> n).sum();
        System.out.println("Sum of integers using mapToInt : " + sum);

        // Sum up all integers in integer array using reduce - variant-1
        // reduce(BinaryOperator accumulator)
        Optional<Integer> sum1 = Stream.of(numbers).reduce((a, b) -> a + b);
        System.out.println("\nSum of integers using reduce - variant-1: " + sum1.get());


        // Sum up all integers in integer array using reduce - variant-2
        // reduce(T identity, BinaryOperator accumulator)
        Integer sum2 = Stream.of(numbers).reduce(0, (a, b) -> a + b);
        System.out.println("\nSum of integers using reduce - variant-2: " + sum2);


        // Sum up all integers in integer array using reduce - variant-3
        // reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator combiner)
        Integer sum3 = Stream.of(numbers).reduce(0, (a, b) -> a + b, Integer::sum);
        System.out.println("\nSum of integers using reduce - variant-3: " + sum3);


        // we can define and use our custom method , then we can pass it as function parameter
        Integer sum4 = Stream.of(numbers).reduce(0, ArithmaticUtils::add);
        System.out.println("\nSum of integers using reduce - custom method : " + sum4);


        // get max salary using BinaryOperator
        List<Developer> developers = List.of(new Developer("Raghavender", 39000),
                new Developer("Manikanta", 99000),
                new Developer("Yuvaraj", 85000),
                new Developer("Kesavan", 49000),
                new Developer("Pavan", 56000));

        Developer maxSalary = findMaxSalary(developers, BinaryOperator.maxBy(Comparator.comparing(Developer::salary)));
        System.out.println("Max salary of Developer : " + maxSalary);

        // method-2 to get max/min salary of developers
        Developer developer = developers.stream().max(Comparator.comparing(Developer::salary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Max salary of Developer : "+developer.salary());

    }

    private static Developer findMaxSalary(List<Developer> list, BinaryOperator<Developer> accumulator) {
        Developer result = null;
        for (Developer t : list) {
            if (result == null) {
                result = t;
            } else {
                result = accumulator.apply(result, t);
            }
        }
        return result;
    }

    private static <T> T sumTotal(List<T> list, T init, BinaryOperator<T> accumulator) {
        T result = init;
        for (T t : list) {
            result = accumulator.apply(result, t);
        }
        return result;
    }
} //main

class ArithmaticUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}

record Developer(String name, int salary) {

}
