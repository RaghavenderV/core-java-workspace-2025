package com.vodapally.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFirstRepetitiveAndNonRepetitive {
    public static void main(String[] args) {
        String s = "Hi Hello World";

        //First Non Repeated Character
        Character c = s.chars().mapToObj(ch -> (char) ch)//Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();


        System.out.println("First Non Repeated Character: " + c); //First Non Repeated Character: i

        //Find first repeated character
        Character character = s.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(enntry -> enntry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        System.out.println("First Repeated Character: " + character); //First Repeated Character: H

        // Read text file using stream
        String filePath = "G://core-java-workspace-2025/src/main/resources/readme.txt";
        try(Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(System.out::println);
        }
        catch (IOException exception){
            System.out.println("Due to : "+exception);
        }
    }
}
