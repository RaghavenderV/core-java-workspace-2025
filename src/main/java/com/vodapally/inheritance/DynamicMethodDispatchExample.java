package com.abhi.inheritance;
/*
* Author@ Raghavender Vodapally
* Date@ Feb 6, 2018
*/
//https://www.youtube.com/watch?v=eIO9dNLkhDQ
class SuperShow{
	
	public void show() {
		System.out.println("in class SuperShow");
	}
	
}

class SubShow extends SuperShow{
	
	@Override
	public void show() {
		System.out.println("in class SubShow");
	}
	
	public void config() {
		System.out.println("SubShow: config()");
	}
	
	
}

class LastShow extends SuperShow{
	
	@Override
	public void show() {
		System.out.println("in class LastShow");
	}
}

public class DynamicMethodDispatchExample {

	public static void main(String[] args) {
		
		SuperShow obj = new SubShow(); //this link is decided at runtime; 
		obj.show();	//which show() method will be called also decided at runtime
		
		//obj.config(); // you can not call config() even it is defined in SubShow class. 
						//compile time it checks whether config() exists in super class. While running it binds the actual class

		
		obj = new LastShow();
		obj.show();
		
		//we are calling show() method with different objects. this is called Dynamic method dispatch
	}

}

