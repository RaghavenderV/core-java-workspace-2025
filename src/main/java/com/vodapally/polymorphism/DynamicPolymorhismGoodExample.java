package com.abhi.polymorphism;

class SuperClass{
	void method(){
		System.out.println("method of super class");
	}
}

class SubClass extends SuperClass{
	//Super Class Method Overrided
	@Override
	void method() {
		System.out.println("method of sub class");
	}
}

public class DynamicPolymorhismGoodExample {
	
	public static void util(SuperClass obj){
		obj.method();
		//For each execution of this method, different objects will be passed to it.
        //which Object will be used is determined during run time only.
        //This shows dynamic polymorphism.
	}

	public static void main(String[] args) {
		SuperClass superClass1 = new SuperClass();
		
		SubClass subClass = new SubClass();
		
		SuperClass superClass2 = new SubClass();
		
		util(superClass1); // SuperClass object is passed to util()
		util(subClass);		//SubClass object is passed to util()	
		util(superClass2);  //SubClass object is passed to util()

	}

}
//http://javaconceptoftheday.com/polymorphism-in-java/
/* op:
method of super class
method of sub class
method of sub class*/

