package com.vodapally.collections;

import java.util.Arrays;
import java.util.List;

public class ArraysasListVsListOf {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4};
        List<Integer> list = Arrays.asList(array); // same as Arrays.asList(1,2,3,4)

        // 1. The method asList() returns a fixed-size list.
        // Therefore, adding and removing new elements throws an UnsupportedOperationException
        //list.add(56); // throws UnsupportedOperationException

        // 2. We should note that the list doesn’t create a copy of the input array.
        // Instead, it wraps the original array with the List interface. Therefore, changes to the array reflect on the list too
        array[0]=3055;
        System.out.println(list.get(0));

        //3. The list returned by Arrays.asList() is mutable. That is, we can change the individual elements of the list
        list.set(1, 100);
        System.out.println("list = " + list);

        // The main difference from Arrays.asList() is that List.of() returns an immutable list that is a copy of the provided input array.
        // For this reason, changes to the original array aren’t reflected on the returned list.
        String[] strArray = new String[]{"one", "two", "three"};
        List<String> stringList = List.of(strArray);
        strArray[0] = "thousand";
        System.out.println("stringList = " + stringList);

        // we cannot modify the elements of the list. If we try to, it will throw UnsupportedOperationException
        //stringList.set(1, "four"); // // throws UnsupportedOperationException

        // List.of() doesn’t allow null values as input and will throw a NullPointerException:
        // List<String> nullTest = List.of("five", null);
        //System.out.println("nullTest = " + nullTest); // NullPointerException

    }
}
