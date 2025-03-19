package com.abhi.interfaces;

import java.io.IOException;

// interface and abstract methods throwing exception.
// not showing any exception at implemented method

interface Test{
	public abstract void method1()throws Exception;
}

abstract class Test1{
	public abstract void method2() throws Exception;
}

public class InterfaceException extends Test1 implements Test{
	
	@Override
	public void method1(){
		System.out.println("interface");
		
	}
	public static void main(String[] args) {
	 InterfaceException obj = new InterfaceException();
	 obj.method1();
	 obj.method2();
	}
	@Override
	public void method2(){
		System.out.println("abstract");
		
	}

}
