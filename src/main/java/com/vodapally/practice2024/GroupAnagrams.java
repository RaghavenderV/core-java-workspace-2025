package com.vodapally.practice2024;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] words = {"listen", "silent", "enlist", "eat", "tea", "dolor", "lored"};

        findAnagrams(words);
        /*Anagram Group: [eat, tea]
        Anagram Group: [listen, silent, enlist]
        Anagram Group: [dolor]
        Anagram Group: [lored]*/
    }

    private static void findAnagrams(String[] words) {
        Map<String, List<String>> map = Stream.of(words).collect(Collectors.groupingBy(word -> {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }));

        map.forEach((key, value) -> System.out.println("Anagram Group: "+value));

    }

}

