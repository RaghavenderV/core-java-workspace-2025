package com.vodapally.logics;

import java.util.Scanner;

/*
 * Author@ Siri-Raghu
 * Date@ 24-Oct-2014
 */
public class ArmstrongNumber {

	public static void main(String[] args) {

		boolean result = isArmstrong(153);
		
		if (result) {
			System.out.println("ARMSTRONG");//eg:153 = 1cube+5cube+3cube
		} else {
			System.out.println("NOT ARMSTRONG");
		}

	}

	private static boolean isArmstrong(int inputValue) {
		String input = inputValue+""; // here int is converted to string; to find the length of integer in easiest manner
		int numOfDigits = input.length();
		int copyOfInput = inputValue;
		
		int sum = 0;
		
		while(copyOfInput!=0){
			int lastDigit = copyOfInput % 10; // this returns remainder which is last digit
			sum = (int)(sum + Math.pow(lastDigit, numOfDigits));
			copyOfInput = copyOfInput/10;
		}
		
		if (sum == inputValue)
			return true;
		else
			return false;
	}
}
