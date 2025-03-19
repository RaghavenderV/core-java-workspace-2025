package com.vodapally.exceptions;

public class TryCatchReturn {
	
	public static void main(String[] args) {
		int returned = calc();
		System.out.println("Returned: "+returned);
	
	}
	
	public static int calc(){
		try{
			System.out.println("in try");
			//return 10;  //comment and test
			throw new Exception(); //uncomment and test
		}
		catch(Exception e){
			System.out.println("in catch");
			return 20;
		}
		finally{
			System.out.println("in finally..");
			return 30;
		}
	}
	

}
