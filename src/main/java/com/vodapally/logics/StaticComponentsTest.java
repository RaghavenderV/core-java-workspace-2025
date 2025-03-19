package com.vodapally.logics;

class StaticComponents{
	static int staticVariable;
	
	static{
		System.out.println("StaticComponents SIB");//SIB- Static Initializer Block
		staticVariable = 10;
	}
	
	static void staticMethod(){
		System.out.println("From static method");
		System.out.println(staticVariable);
	}
}

public class StaticComponentsTest {
	static{
		System.out.println("Main Class SIB..");
	}

	public static void main(String[] args) {
		// static members can be directly accessed with class name
		StaticComponents.staticVariable = 20;
		StaticComponents.staticMethod();

	}

}
