package com.vodapally.logics;

import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseNumber {

    public static void main(String[] args) {

        int input = 12345, input2 = 6789;

        int reversed = reverseInteger(input);
        System.out.println("Original: " + input + "\nReversed: " + reversed);

        int reversed2 = revrseDigits(input2);
        System.out.println("Original: " + input2 + "\nReversed: " + reversed2);
    }

    private static int revrseDigits(int n) {
        int revNum = 0;
        while (n > 0) {
            revNum = revNum * 10 + n % 10;
            n = n / 10;
        }
        return revNum;
    }

    public static int reverseInteger(int number) {
        String reversedString = Integer.toString(number)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
                    Collections.reverse(lst);
                    return lst.stream();
                }))
                .map(String::valueOf)
                .collect(Collectors.joining());

        return Integer.parseInt(reversedString);
    }

}

