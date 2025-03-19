package com.vodapally.practice;

//PracticeTest
//Java implementation of the above approach 
class PracticeTest {

	static void printValue(char digit) {

		switch (digit) {

		case '0':
			System.out.print("Zero ");
			break;

		// For digit 1
		case '1':
			System.out.print("One ");
			break;

		case '2':
			System.out.print("Two ");
			break;

		case '3':
			System.out.print("Three ");
			break;

		case '4':
			System.out.print("Four ");
			break;

		// For digit 5
		case '5':
			System.out.print("Five ");
			break;

		// For digit 6
		case '6':
			System.out.print("Six ");
			break;

		// For digit 7
		case '7':
			System.out.print("Seven ");
			break;

		// For digit 8
		case '8':
			System.out.print("Eight ");
			break;

		// For digit 9
		case '9':
			System.out.print("Nine ");
			break;
		}
	}

	static void printWord(String input) {

		// Finding each digit of the number
		for (int i = 0; i < input.length(); i++) {

			// Print the digit in words
			printValue(input.charAt(i));
		}
	}

	public static void main(String[] args) {
		String input = "3055";
		System.out.println("input : " + input);
		printWord(input);
	}
}
