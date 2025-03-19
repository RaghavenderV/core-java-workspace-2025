package com.vodapally.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, 25.5),
                new Item("banana", 20, 12.6),
                new Item("orange", 10, 32.2),
                new Item("watermelon", 10, 56.4),
                new Item("papaya", 20, 35.6),
                new Item("apple", 10, 58.2),
                new Item("banana", 10, 32.9),
                new Item("apple", 20, 69.4)
        );

        //group by item name and its count
        Map<String, Long> map = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(map);

        //sort map by values in descending - quantity
        Map<String, Long> sortedMap = new LinkedHashMap<>();

        map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

        System.out.println("\nAfter sorting map by values(quantity)\n" + sortedMap);


        System.out.println("\n\n****************************************************************");
        System.out.println("\nFind the length of each string in string array");

        Map<String, Integer> nameLengthMap = Stream.of("India", "America", "South Africa", "Indonesia")
                .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println(nameLengthMap);
        nameLengthMap.forEach((name,length) -> {
            System.out.println(name+" : "+length);
        });
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Item {
    private String name;
    private int qty;
    private double price;

}
