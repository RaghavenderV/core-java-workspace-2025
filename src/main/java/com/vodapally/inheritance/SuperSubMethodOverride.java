package com.vodapally.inheritance;

class A1{
	void X(){
		System.out.println("From Super Class");
	}
}

class B1 extends A1{
	// here super class method is not overridden as the args not matching;instead X() is overloaded
	void X(int a){
		System.out.println("From Subclass.."+a);
	}
}

public class SuperSubMethodOverride {
	public static void main(String[] args) {
				
		A1 a1 = new A1();
		B1 b1 = new B1();
		
		a1.X();
		
		b1.X(55);
		
	}

}
