package com.vodapally.exceptions;

public class ExceptionHandlingReturn1 {
	//finally block overrides any return values from try and catch blocks.

	public static void main(String[] args) {
		System.out.println("return = "+method());
		int i = method();
		System.out.println(i);

	}
	static int method(){
		try{
			return 10;
		}
		catch(Exception e){
			return 20;
		}
		finally{
			return 30;
		}
	}

}
