package com.vodapally.logics;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		int factorial = 1;
		System.out.println("Enter positive integer");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i=1; i<=n; i++){
			factorial = factorial*i;
		}
		
		System.out.println("Factorial : "+factorial);
		
		System.out.println("RECURSION\n");
		
		//int fact = 1;
		
		int fact = factorial(n);
		
		System.out.println("Factorial using recursion: "+fact);
		
		in.close();
	}
	
	public static int factorial(int n){
		if(n==0){
			return 1;
		}
		else{
			return (n*factorial(n-1));
		}
		
	}

}
