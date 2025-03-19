package com.vodapally.logics;

public class Test01 {
	public static int num = 99;

	public static void main(String[] args) {
		Test01 test01 = null;
		System.out.println(test01.num); // prints 99; no issues
		
		System.out.println("asked in accolite");
		boolean[] b1 = new boolean[10];
		Boolean[] B2 = new Boolean[10];
		
		System.out.println("b1[0] : " + b1[0]); // false
		System.out.println("B2[0] : " + B2[0]); //null
		
		//testing
		for(boolean obj :b1) {
			System.out.println("boolean : "+obj);
		}
		
		//other piece of code
		
		if(3*0.2 == 0.6){ //false
			System.out.println("if loop");
		}
		else{
			System.out.println("in else.."); // this gets executed
		}

	}

}
