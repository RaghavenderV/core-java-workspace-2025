package com.vodapally.exceptions;
/*
* Author@ Raghavender Vodapally
* Date@ Sep 5, 2017
*/
public class UnreachableCode {

	public static void main(String[] args) {
		try {
			System.out.println("try");
			//return;
		}
		catch(Exception e) {
			System.out.println("Exception : "+e);
			return;
		}
		finally {
			System.out.println("Finally ..");
			//return;
		}
		System.out.println("Iam unreachable"); //comment line 11 and check

	}

}

