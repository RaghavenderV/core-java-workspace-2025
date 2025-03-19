package com.vodapally.logics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println("Enter any integer: ");
		//Scanner in = new Scanner(System.in);
		//int n = in.nextInt();
		int n=7;

		int f1, f2 = 0, f3 = 1;
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <=n; i++) {
			System.out.print(" " + f3 + " ");
			f1 = f2;
			f2 = f3;
			f3 = f1 + f2;
			list.add(f3);
		}
		//in.close();

		int find =6;
		
		Integer result = list.get(find-2);
		System.out.println("\nFibonacci value at : "+find);
		System.out.println(result);
		
	}

}
