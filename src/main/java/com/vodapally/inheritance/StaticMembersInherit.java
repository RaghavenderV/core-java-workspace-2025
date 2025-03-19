package com.vodapally.inheritance;
//Static members are also inherited to sub classes as static members only

class MySuper{
	static public int i = 99;
	
	static void test(){
		System.out.println("static method");
	}
	
	
}
class Nothing extends MySuper{
	//below code will lead to compile time error as we can't override static methods.
	/*void test() {
		
	}*/
	static int i=88;
	public static void main(String[] args) {
		System.out.println("super i = "+MySuper.i+" ; sub i ="+i);
	}
	
}
	

public class StaticMembersInherit {

	public static void main(String[] args) {
		Nothing.test();
		System.out.println("static var value = "+ Nothing.i);

	}

}
