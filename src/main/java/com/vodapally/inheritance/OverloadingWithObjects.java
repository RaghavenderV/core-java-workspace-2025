package com.vodapally.inheritance;

/*
* Author@ Raghavender Vodapally
* Date@ Sep 12, 2017
*/

class Mobile{}

class SmartPhone extends Mobile{
	
}

class Communication{
	public void call(Mobile m) {
		System.out.println("Mobile..");
	}
	
	public void call(SmartPhone s) {
		System.out.println("Smartphone..");
	}
}

public class OverloadingWithObjects {

	public static void main(String[] args) {
		Mobile m = new Mobile();
		SmartPhone s = new SmartPhone();
		Mobile a = new SmartPhone();
		
		Communication c = new Communication();
		c.call(m);//Mobile..
		c.call(s);//Smartphone..
		c.call(a);//Mobile..
		

	}

}

