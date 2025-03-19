package com.vodapally.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMethods {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Map<String, String> minMaxMap = list.stream().collect(Collectors.teeing(
                Collectors.minBy(Integer::compareTo),
                Collectors.maxBy(Integer::compareTo),
                (e1, e2) -> Map.of("min: " + e1.get(), "max: " + e2.get())
        ));

        System.out.println(minMaxMap);
    }
}
