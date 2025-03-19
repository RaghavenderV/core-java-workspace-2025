package com.vodapally.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.geeksforgeeks.org/java-8-streams-collectors-joining-method-with-examples/?ref=asr2
public class JoiningInCollectors {
    public static void main(String[] args) {
        // joining() is used to join various elements of a character or string array into a single string object.
        char[] charArrray = {'R','A','G','H','U'};
        String name = Stream.of(charArrray)
                //.map(ch -> new String(ch))
                .map(String::valueOf) // both works
                .collect(Collectors.joining());
        System.out.println("name = " + name); // RAGHU

        List<String> list = List.of("Make", "In", "India");
        String s = list.stream().collect(Collectors.joining());
        System.out.println("s = " + s);

        // with delimiter
        String s1 = list.stream().collect(Collectors.joining("*"));
        System.out.println("s1 = " + s1);
    }
}
