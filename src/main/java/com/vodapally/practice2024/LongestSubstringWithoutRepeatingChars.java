package com.vodapally.practice2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.youtube.com/watch?v=VvS_CtSIeiQ&list=PLjOcsOwEjb12G3uwXNdzyyIs0tNql-2Am&index=13
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String input = "abcabcbb";/// o/p: 3 -> abc
        String input2 = "bbbbb";//o/p: 1 -> b
        String input3 = "pwwkew"; //o/p: 3 -> wke


        int max = lengthOfLongestSubstring(input3);
        System.out.println("LongestSubstringWithoutRepeatingChars in sequence : " + max);

    }

    //sliding window algorithm
    private static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 0;

        List<Character> list = new ArrayList<>();

        while (end < s.length()) {//abcabcbb->3
            if (!list.contains(s.charAt(end))) {
                list.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, list.size());
            } else {
                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return maxLength;
    }
}
