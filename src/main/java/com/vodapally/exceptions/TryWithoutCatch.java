package com.vodapally.exceptions;

public class TryWithoutCatch {
	
	public static void main(String[] args) {
		try{
			System.out.println("try..");
			int i=10/0;
			System.out.println("I am never executed..");
		}
		catch(ArithmeticException e){ //catch is optional, if we use finally
			System.out.println(e);
		}
		finally{
			System.out.println("inside finally block"); // always gets executed even if exception raised in try block
			
		}
		
		System.out.println("I'm executed if you catch the exception.."); // this gets executed when we catch the exception in catch block
		//comment catch block
	}

}
