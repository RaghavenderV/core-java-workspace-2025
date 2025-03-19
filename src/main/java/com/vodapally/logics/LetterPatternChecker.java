package com.vodapally.logics;

import java.util.HashMap;
import java.util.Map;

public class LetterPatternChecker {

    public static boolean hasSameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        // Maps to store the character mappings from str1 to str2 and vice versa
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) { // ABAB CDCD
            char char1 = str1.charAt(i);//AB
            char char2 = str2.charAt(i);//CD

            // Check if the current character in str1 has been mapped before
            if (map1.containsKey(char1)) {
                // If it has been mapped, check if it maps to the same character in str2
                if (map1.get(char1) != char2) {//
                    return false;
                }
            } else {
                // If it hasn't been mapped, add the mapping to the map
                map1.put(char1, char2);//A,C
            }

            // Check if the current character in str2 has been mapped before
            if (map2.containsKey(char2)) {
                // If it has been mapped, check if it maps to the same character in str1
                if (map2.get(char2) != char1) {
                    return false;
                }
            } else {
                // If it hasn't been mapped, add the mapping to the map
                map2.put(char2, char1);//C,A
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abba";
        String str2 = "cddc";

        System.out.println(hasSameLetterPattern(str1, str2)); // Output: true

        str1 = "abc";
        str2 = "xyz";

        System.out.println(hasSameLetterPattern(str1, str2)); // Output: true

        str1 = "abc";
        str2 = "xxy";

        System.out.println(hasSameLetterPattern(str1, str2)); // Output: false
    }
}
