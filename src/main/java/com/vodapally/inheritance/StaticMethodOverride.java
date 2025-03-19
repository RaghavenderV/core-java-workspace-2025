package com.vodapally.inheritance;

class Super{
	public static void method1() {
		System.out.println("super class method()...");
	}
}
class MySubClass extends Super{
	public static void method1() {
		System.out.println("sub class method()....");
	}
}
public class StaticMethodOverride {
	public static void main(String[] args) {
		Super super1=new MySubClass();
		MySubClass obj = new MySubClass();
		
		super1.method1();//super class method1... 
		obj.method1();//sub class method....
	}

}
//static method can not be overridden; remove static keyword from above methods and chk result
// This is a perfect example for static binding.

/*
compiler knows that it will not be overridden in subclasses and hence compiler knows during compile time 
which print method to call and hence no ambiguity.
*/