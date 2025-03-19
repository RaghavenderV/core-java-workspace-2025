package com.vodapally.logics;

public class ClimbStairCase {
    public static void main(String[] args) {
        int n = 5; // stair case steps
        int result = climbStairCase(n);
        System.out.println(n + " step stair case, you can reach in different ways is: " + result);
    }

    private static int climbStairCase(int n) {
        if (n <= 3) {
            return n;
        }

        int a = 3, b = 2;
        for (int i = 0; i < n - 3; i++) {
            a = a + b;
            b = a - b; // to hold the previous value
        }

        return a;

    }
}
//https://www.youtube.com/watch?v=cGTFd5MbJ_4
//https://leetcode.com/problems/climbing-stairs/description/
//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// this is a fibonacci series problem