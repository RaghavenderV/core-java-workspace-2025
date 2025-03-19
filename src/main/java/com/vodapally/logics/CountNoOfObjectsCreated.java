package com.vodapally.logics;
/*
* Author@ Raghavender Vodapally
* Date@ Sep 12, 2017
*/

class CountMe{
	static int i=0;
	
	public CountMe() {
		i++;
	}
	
	public void countObjects() {
		System.out.println("Objects created: "+i);
	}
}
public class CountNoOfObjectsCreated {

	public static void main(String[] args) {
		CountMe obj1 = new CountMe();
		CountMe obj2 = new CountMe();
		CountMe obj3 = new CountMe();
		CountMe obj4 = new CountMe();
		
		obj1.countObjects();

	}

}

