package com.vodapally.exceptions;
/*
* Author@ Raghavender Vodapally
* Date@ Jun 30, 2018
*/
public class ThrowsDemo {

	public static void main(String[] args) {
		try {
			methodThrows();
		}
		catch(NullPointerException ne) {
			System.out.println("Caught in catch block: "+ne);
		}

	}

	static void methodThrows() throws NullPointerException{
		String s=null;
		s.length();
		
	}

}

