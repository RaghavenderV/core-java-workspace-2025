package com.vodapally.logics;

class X{
	void method(int a){
		System.out.println("ONE");
	}
	
	void method(double b){
		System.out.println("TWO");
	}
}

class Y extends X{
	@Override
	void method(double b) {
		System.out.println("THREE");
	}
	
}

public class MethodOverloadOverride {

	public static void main(String[] args) {
		Y y = new Y();
		y.method(100); //ONE
		y.method(100.99); //THREE
		y.method(63.2f); //THREE

	}

}
