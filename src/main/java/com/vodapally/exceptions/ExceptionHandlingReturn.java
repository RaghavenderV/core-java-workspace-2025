package com.vodapally.exceptions;

public class ExceptionHandlingReturn {

	public static void main(String[] args) {
		method();
		System.out.println("done");

	}
	static void method(){
		try{
			System.out.println("try");
			int i=10/0;
			return;
		}
		catch(Exception e){
			System.out.println("catch");
			//System.exit(0); //will be terminated here
			return;
		}
		finally{
			System.out.println("finally");
			return;
		}
	}
	
	//finally block will be always executed(except scenario:  System.exit(0)) even though try and catch blocks are returning the control.
	//http://javaconceptoftheday.com/return-value-from-try-catch-finally-blocks/

}
