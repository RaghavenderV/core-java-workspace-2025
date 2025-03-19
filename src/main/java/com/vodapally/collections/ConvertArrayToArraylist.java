package com.vodapally.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertArrayToArraylist {
    public static void main(String[] args) {
        // first method
        String[] array = new String[]{"Needle", "Bobbin", "Thread","Cutter"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));

        for (String s: list){
            System.out.print(s+" ");
        }
        System.out.println();

        // second method
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, array);

        for (String s: list1){
            System.out.print(s+" ");
        }
        System.out.println();

        // third method
        List<String> strings = Arrays.stream(array).collect(Collectors.toList());
        for (String s: strings){
            System.out.print(s+" ");
        }
        System.out.println();

        //Convert list to array
        List<Integer> ints = new ArrayList<>(Arrays.asList(10,20,30,40));
        Integer[] intArray = new Integer[ints.size()];
        ints.toArray(intArray);
        for (Integer i: intArray){
            System.out.print(i+" ");
        }
    }
}
