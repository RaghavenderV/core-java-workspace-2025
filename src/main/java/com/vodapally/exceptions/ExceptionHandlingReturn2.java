package com.vodapally.exceptions;

public class ExceptionHandlingReturn2 {

	public static void main(String[] args) {
		
		System.out.println("from main ; i = "+method());

	}
	static int method(){
		int i=0;
		try{
			i = 1;
			System.out.println("try: i: "+i);
			//System.exit(0); //if this,  finally block will not execute
			return i;
		}
		catch(Exception e){
			i = 2;
			return i;
		}
		finally{
			i=3;
			//System.exit(0); // check this also; 
			System.out.println("finally block "+i);
			return i;
		}
	}
	
	//finally block will always be executed even though try and catch blocks are returning the control.
	//http://javaconceptoftheday.com/return-value-from-try-catch-finally-blocks/

}
