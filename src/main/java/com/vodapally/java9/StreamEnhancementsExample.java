package com.vodapally.java9;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEnhancementsExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> taken = numbers.stream()
                .takeWhile(n -> n < 5)
                .collect(Collectors.toList());
        System.out.println(taken); // Output: [1, 2, 3, 4]

        List<Integer> dropped = numbers.stream()
                .dropWhile(n -> n < 5)
                .collect(Collectors.toList());
        System.out.println(dropped); // Output: [5, 6, 7, 8, 9]

        System.out.println("\nStream iterator:");
        Iterator<Integer> iterator = numbers.stream().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        // java 16 feature: Text blocks simplify the creation of multi-line strings by using triple quotes (""").
        String html= """
                        hello
                        how are 
                        you.
                        happy valentines day
                      """;
        System.out.println("\nhtml = " + html);

    }
}

