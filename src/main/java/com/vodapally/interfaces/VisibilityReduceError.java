package com.abhi.interfaces;

interface TestMe{
	public void test();
}

class TestMeImpl implements TestMe{
	@Override
	public void test() { // remove 'public' and test; we can not reduce the visibility
		System.out.println("from TestImpl.test()");
		
	}
}

public class VisibilityReduceError {

	public static void main(String[] args) {
		TestMe obj = new TestMeImpl();
		obj.test();

	}

}
