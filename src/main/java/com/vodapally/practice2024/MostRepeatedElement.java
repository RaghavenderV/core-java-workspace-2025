package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostRepeatedElement {

    public static void main(String[] args) {
        // find the most repeated string in given array --> Pen
        List<String> list = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");

        Entry<String, Long> entry = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Entry.comparingByValue()).get();

        System.out.println("Most repeated element in list : " + entry.getKey() + " -> " + entry.getValue()); //Pen

        String s = "i love love love india";

        Entry<String, Long> entry1 = Stream.of(s.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Entry.comparingByValue())
                .get();


        System.out.println("Most repeated word in string : " + entry1.getKey() + " -> " + entry1.getValue());


    }

}
