package com.abhi.interfaces;

interface MyInterface{
	public static final int i = 100;
	public abstract void methodOne();
}
public class InterfaceFields implements MyInterface {
	
	void canWeChange(){
		//MyInterface.i = 200; // final field can not re-assigned
	}
	
	//according to method overriding rule, you can’t reduce visibility of super class method. 
	@Override
	public void methodOne() {
		// TODO Auto-generated method stub
		
	} // remove public access specifier and check

}
