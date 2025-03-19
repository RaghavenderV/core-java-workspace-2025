package com.vodapally.inheritance;
/*
* Author@ Raghavender Vodapally
* Date@ Dec 27, 2017
*/

class X{
	
	  //public void test() { System.out.println("from superclass -> X:test()"); }
}

class Y extends X{

	public void test() {
		System.out.println("from subclass -> Y:test()");
	}
}
public class BindingDemo {

	public static void main(String[] args) {
		
		X obj = new Y();
		//obj.test(); //uncomment this and test
		
		// it is clear that while binding it looks for the method in reference type obj. that is super class
		// in above scenario.
		//http://javaconceptoftheday.com/static-binding-and-dynamic-binding-in-java/
		
	}

}
/*
 * During compilation, while binding, compiler does not check the type of object
 * to which a particular reference variable is pointing. It just checks the type
 * of reference variable through which a method is called and checks whether
 * there exist a method definition for it in that type.
 */
