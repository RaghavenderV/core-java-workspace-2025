package com.vodapally.practice2024;

public class ReverseWordsInSameOrder {
    public static void main(String[] args) {
        String input = "  the sky is   blue  ";//input may have leading, trialing and in-between spaces
        //blue is sky the-> remove all spaces
        String reverseString = reverseWords(input);
        System.out.println("reverseString = " + reverseString);
    }

    private static String reverseWords(String input) {

        String[] words = input.split(" +");//it splits the string as space with anything
        StringBuilder sb = new StringBuilder();

        for (int i = words.length-1; i>=0;i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
