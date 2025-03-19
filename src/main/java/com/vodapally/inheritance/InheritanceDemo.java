package com.vodapally.inheritance;

class A{
	private int i;
	
	A(int i){
		this.i = i;
		System.out.println("Class A constructor..");
		System.out.println("i = "+i);
	}
}

class B extends A{
	
	public B(){
		
		super(99); // comment this line and check
		System.out.println("Class B constructor..");
	}
}

public class InheritanceDemo {

	public static void main(String[] args) {
		new B();

	}

}
