package com.vodapally.inheritance;
/*
 * Author@ Siri-Raghu
 * Date@ 20-Sep-2014
 */
class SuperClass {
	
	SuperClass(){
		System.out.println("I am a super default constructor... ");//4
	}
	static{
		System.out.println("I am a super static block...");//1
	}
	
	{
		System.out.println("I am a super instance Block...");//3
	}//instance block
}

class SubClass extends SuperClass {
	SubClass(){
		System.out.println("I am a subclass default constructor... ");//6
	}
	static{
		System.out.println("I am a subclass static block...");//2
	}
	
	{
		System.out.println("I am a subclass instance Block...");//5
	}
}

public class SuperSubExecutionFlow {
	
	public static void main(String[] args) {
		new SubClass();
	}

}
/*I am a super static block...
I am a subclass static block...
I am a super instance Block...
I am a super default constructor... 
I am a subclass instance Block...
I am a subclass default constructor...*/ 


