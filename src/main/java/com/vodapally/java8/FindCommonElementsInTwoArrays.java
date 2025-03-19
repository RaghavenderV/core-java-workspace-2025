package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindCommonElementsInTwoArrays {
    public static void main(String[] args) {
        int[] array1 = {3,4,5,1,2,8};
        int[] array2 = {9,4,6,1,4,8};

        List<Integer> list1 = Arrays.stream(array1).boxed().collect(Collectors.toList());
        Set<Integer> commonElements = Arrays.stream(array2).boxed().filter(list1::contains).collect(Collectors.toSet());

        System.out.println("Common elements: "+commonElements);
    }

}
