package com.vodapally.exceptions;

/*
 * Author@ Raghavender Vodapally
 * Date@ Aug 5, 2017
 */
//asked in accolite
public class WhatOutput {

    public static void main(String[] args) {
        try {
            throwError();
            System.out.println("after try");
        } catch (Throwable e) { //change Exception to Throwable and check output
            System.out.println("in catch");
        } finally {
            System.out.println("in finally");
            //other piece of code
            byte b = 127;
            b++;
            //b++;
            System.out.println("b = " + b); // -128
        }

        justCall(); // if we catch the above Error/Exception, then below stmts get executed
        System.out.println("The END");

    }

    private static void justCall() {
        System.out.println("justCall");

    }

    private static void throwError() {
        throw new Error();

    }

}

