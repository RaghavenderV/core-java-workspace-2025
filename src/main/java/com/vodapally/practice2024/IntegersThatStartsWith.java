package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class IntegersThatStartsWith {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12, 19, 10, 99, 20, 159, 98);
        System.out.println(list);

        // sorting the integers that starts with '1'
        list.stream().filter(i -> String.valueOf(i).startsWith("1"))
                .sorted(Comparator.naturalOrder())
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        //reverse an integer array {5, 1, 7, 3, 9, 6} -> [6,9,3,7,1,5]
        int[] iArray = {5, 1, 7, 3, 9, 6};
        System.out.println(Arrays.toString(iArray));
        IntStream.rangeClosed(1, iArray.length).forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream.rangeClosed(1, iArray.length)
                .map(i -> iArray[iArray.length - i])
                .forEach(i -> System.out.print(i + " "));
    }

}
