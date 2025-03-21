package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByEvenOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<String, List<Integer>> evenOddGroups = numbers.stream().collect(
                Collectors.groupingBy(n -> (n % 2 == 0) ? "Even" : "Odd"));

        System.out.println("evenOddGroups = " + evenOddGroups);
    }
}
