package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


record Product(String category, int price) {
}

public class GroupingWithSumming {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Electronics", 100),
                new Product("Electronics", 200),
                new Product("Clothing", 50),
                new Product("Clothing", 75),
                new Product("Groceries", 30)
        );

        // Group By category and sum prices
        Map<String, Integer> categoryTotalPrice = products.stream().collect(Collectors.groupingBy(
                Product::category,
                Collectors.summingInt(Product::price)
        ));

        System.out.println(categoryTotalPrice);
    }
}
