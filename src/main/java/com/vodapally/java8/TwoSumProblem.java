package com.vodapally.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/check-if-pair-with-given-sum-exists-in-array/
//https://www.youtube.com/watch?v=pyt-RGt7slA&t=31s
public class TwoSumProblem {
    public static void main(String[] args) {
        int[] array = {3, 2, 4};
        int target = 6;
        int[] indicesPair = twoSum(array, target);
        System.out.println("Array indices : " + Arrays.toString(indicesPair)); //Array indices : [1, 2]

        int[] array1 = {2, 7, 11, 5};
        int target1 = 9;
        int[] indicesPair1 = twoSum(array1, target1);
        System.out.println("Array indices : " + Arrays.toString(indicesPair1)); //Array indices : [0, 1]
    }

    private static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int requiredNum = target - array[i];
            if (map.containsKey(requiredNum)) {
                int[] result = {map.get(requiredNum), i};
                return result;
            } else {
                map.put(array[i], i);
            }
        }
        return null;
    }
}
