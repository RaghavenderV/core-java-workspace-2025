package com.abhi.interfaces;

interface A{
	int i =100;
}

class B implements A{
	int i =33;
	void methodB(){
		System.out.println("i = "+i);
		//A.i=200; // uncomment this
	}
}
/*because interface fields are static and final by default and you can’t change their value once they are 
 * initialized. In the above code, methodB() is changing value of interface field A.i. 
 * It shows compile time error.
 */

public class InterfaceErrors {
	public static void main(String[] args) {
		System.out.println(new B().i);
	}

}
