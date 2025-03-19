package com.vodapally.logics;

class A{
	
}

class B extends A{
	
}

class C extends B{
	
}

public class MethodOverloadWithObjects {
	
	static void overloadedMethod(A a){
		System.out.println("overloadedMethod- A");
	}
	
	static void overloadedMethod(B b){
		System.out.println("overloadedMethod- B");
	}
	static void overloadedMethod(Object object){
		System.out.println("overloadedMethod- Object");
	}
	
	

	public static void main(String[] args) {
		
		C c = new C();
		overloadedMethod(c); // output: overloadedMethod- B 
		// it finds the most specific one.
		// pass the arg as 12345 in place of c and test -> prints: overloadedMethod- Object

	}

}
