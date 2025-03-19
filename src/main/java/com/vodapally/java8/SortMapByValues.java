package com.vodapally.java8;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class SortMapByValues {

    public static void main(String[] args) {
        Map<Integer, String> map = Map.of(132, "Chaitanya", 654, "Akhil", 784, "Vijay", 101, "Kajal", 201, "Anjali");

        Map<Integer, String> sortedMapByValue = sortByValue(map);

        System.out.println("\n Using Streams : \n"+sortedMapByValue + "\n");
        System.out.println("--------------------------------");

        // method -2
        Map<Integer, String> sortedMapByValues = sortByValues(map);
        System.out.println("Using list sort() : \n"+sortedMapByValues + "\n");
        System.out.println("--------------------------------");

        // sort the map by keys
        TreeMap<Integer, String> treeMap = new TreeMap<>(map);
        System.out.println("Sorted map by keys : " + treeMap);

    }

    // method - 1
    public static Map<Integer, String> sortByValue(Map<Integer, String> map) {
        return map.entrySet().stream().sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                        (oldValue, newValue) -> newValue,
                        LinkedHashMap::new));

    }

    // method - 2
    public static Map<Integer, String> sortByValues(Map<Integer, String> map) {
        List<Entry<Integer, String>> list = new LinkedList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        System.out.println("LIST --> "+list);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        for (Entry<Integer, String> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;

    }
}
