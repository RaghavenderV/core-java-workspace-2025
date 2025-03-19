package com.abhi.polymorphism;

class OverloadWithStaticKey{
	
	//we can overload with static and access specifiers
	
	int method(int i, int j){
		return i+j;
	}
	
	/*short method(int i, int j){
		return (short)(i+j);
	}*/
	/*
	 *  If two methods have same signature and different return types, then those methods will not be treated as two different methods or methods overloaded. 
	 *  For duplication, compiler checks only method signature not return types.
	 *  If method signature is same, straight away it gives duplicate method error.
	 */
	
	
	static int method(int i, double j){
		return (int)(i+j);
	}
	
	double method(double i, int j){
		return i+j;
	}
	
	static double method(double i, double j){
		System.out.print("from static double : ");
		return i+j;
	}
	
	
	protected int visibilityMethod(int x, int y){
		System.out.print("from protected : ");
		return x+y;
	}
	
	public double visibilityMethod(double x, double y){
		System.out.print("from public : ");
		return (x+y);
	}
	
	 
}

public class OveloadingWithStatic {

	public static void main(String[] args) {
		OverloadWithStaticKey obj = new OverloadWithStaticKey();
		System.out.println(obj.method(50, 50.9));
		System.out.println(obj.method(50.1, 50.9));
		
		System.out.println(obj.visibilityMethod(25, 70));
		System.out.println(obj.visibilityMethod(25.9, 70));

	}

}
