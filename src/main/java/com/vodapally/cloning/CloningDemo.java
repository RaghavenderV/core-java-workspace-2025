/*
* Author@ Raghavender Vodapally
* Date@ Sep 3, 2017
*/
package com.vodapally.cloning;

class Test{
	int i;
	int j;
	
	@Override
	public String toString() {
		return "Test: " + i + " "+j;
	}
}

class UseCloning implements Cloneable{
	int i;
	int j;
	
	@Override
	public String toString() {
		return "UseCloning: " + i + " "+j;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}



public class CloningDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Test obj1 = new Test(); // note that Test class has not implemented Cloneable interface
		obj1.i = 22;
		obj1.j = 33;
		
		Test obj2 = obj1;

		System.out.println("Before changing");
		System.out.println(obj1);//22 33
		System.out.println(obj2);//22 33
		
		obj2.i = 99;
		
		System.out.println("After changing value in obj2");
		System.out.println(obj1); // 99 33
		System.out.println(obj2); // 99 33
		
		//In above approach, we have not changed the value in obj1. but still value got changed. This is the problem in
		// this approach. It's because,  only one object created, referred by two object references. This is SHALLOW COPY
		
		//DEEP COPY
		
		Test obj3 = new Test();
		obj3.i = 60;
		obj3.j = 70;
		
		Test obj4 = new Test(); //copy each variable
		obj4.i = obj3.i;
		obj4.j = obj3.j;

		System.out.println("\n---------------------------------------------");
		System.out.println("Before changing");
		System.out.println(obj3);
		System.out.println(obj4);
		
		obj4.i = 100;
		
		System.out.println("After changing value in obj4");
		System.out.println(obj3); // 60 70
		System.out.println(obj4); // 100 70

		//output as expected. but the problem is: If we have more no.of variables(lets say 100), then
		// we have to copy each variable. So we can go for cloning. it does for us
		
		
		
		//Cloning
		UseCloning obj5 = new UseCloning(); // implemented Cloneable interface
		obj5.i = 23;
		obj5.j = 45;
		
		UseCloning obj6 = (UseCloning)obj5.clone();
		
		System.out.println("\nUsing Cloning..");
		System.out.println("\n---------------------------------------------");
		System.out.println("Before changing");
		System.out.println(obj5); //23 45
		System.out.println(obj6); //23 45
		
		obj6.i = 3055;
		System.out.println("\n---------------------------------------------");
		System.out.println("After changing i value");
		System.out.println(obj5); //23 45
		System.out.println(obj6); //3055 45
		
	}

}

