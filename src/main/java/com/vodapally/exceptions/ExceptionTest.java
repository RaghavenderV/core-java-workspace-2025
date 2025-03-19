package com.abhi.exceptions;
/*
* Author@ Raghavender Vodapally
* Date@ Jan 21, 2018
*/
public class ExceptionTest {

	public static void main(String[] args) {
		
		try {
			System.out.println("Hello "+1/0);
		} catch (Exception e) {
			System.out.println("World");
		}

	}

}
//o/p: World
