package com.vodapally.practice2024;

public class Palindrome {

    public static void main(String[] args) {
        // Palindrome : ROTATOR, MADAM, MALAYALAM
        String str = "MALAYALAM";
        StringBuffer sb = new StringBuffer(str);

        if (str.equals(new StringBuffer(str).reverse().toString()))
            System.out.println(str + " is a palindrome.");
        else System.out.println(str + " is not a palindrome");

        // Palindrome number
        int n = 121;
        boolean result = isPalindrome(n);
        System.out.println(n + " isPalindrome? " + result);
    }

    private static boolean isPalindrome(int num) {
        int temp = num;
        int rev = 0;
        while (num > 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;
        }
        if (rev == temp)
            return true;
        else
            return false;
    }

}
