package com.vodapally.exceptions;

public class ExceptionHandling {

	public static void main(String[] args) {
		try{
			int i = 10/0;
			System.out.println("this stmt will not be executed..");
		}
		//System.out.println("we can not keep stmts here..");
		catch(ArithmeticException e){
			System.out.println("this stmt gets executed..");
		}
		//System.out.println("we can not keep stmts here..");
		finally{
			System.out.println("always executed..");
		}
		
		System.out.println("you can keep any no of stmts here");

	}

}
