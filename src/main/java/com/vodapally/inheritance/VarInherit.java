package com.vodapally.inheritance;
/*
 * Author@ Raghavender Vodapally
 * Date@ Jun 29, 2017
 */

class VarA{
	int i=10;
}

class VarB extends VarA{
	int i=20;
}

public class VarInherit {

	public static void main(String[] args) {
		
		VarA test = new VarB();
		
		System.out.println("i : "+test.i); // i: 10

	}

}

