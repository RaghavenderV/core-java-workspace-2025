package com.vodapally.abstractdemo;

abstract class Abstract1{
	public Abstract1(){
		System.out.println("ONE");
	}
	
	abstract void abstractMethod();
}

class AbstractImpl extends Abstract1{
	public AbstractImpl(){
		System.out.println("TWO");
	}
	
	@Override
	void abstractMethod() {
		System.out.println("THREE");
		
	}
}


public class AbstractConstructorDemo {

	public static void main(String[] args) {
		Abstract1 obj = new AbstractImpl();
		obj.abstractMethod();

	}

}
