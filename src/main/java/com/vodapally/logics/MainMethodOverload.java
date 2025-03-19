package com.vodapally.logics;

public class MainMethodOverload {

	public static void main(String[] args) {
		System.out.println("main");
		main();
		main("hello");

	}
	
	public static void main(){
		System.out.println("main overload");
	}
	public static void main(String s){
		System.out.println("main overload "+s);
	}

}
