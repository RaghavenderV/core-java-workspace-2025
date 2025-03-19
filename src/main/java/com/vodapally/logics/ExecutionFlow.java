package com.vodapally.logics;
/*
 * Author@ Siri-Raghu
 * Date@ 20-Sep-2014
 */
public class ExecutionFlow {
	static int a=10;
	
	//constructor
	ExecutionFlow(){
		System.out.println("I am a default constructor... a= " +a);
	}
	
	//static block
	static {
		System.out.println("I am a static block.  a = "+a);
	}
	
	//initialization block
	{
		System.out.println("I am a instance Block..."+a);
	}
	
	public static void main(String[] args) {
		
	 new ExecutionFlow();
}
	
/*static	int a=10,b=3;
	static {
		System.out.println((a+b));
	}*/

}
/** output */
/*I am a static block.  a = 0
I am a instance Block...
I am a default constructor... a= 0
*/
