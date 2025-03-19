package com.vodapally.logics;
/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 21, 2017
 */

class TestFinalize{

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method called: ");
	}
}

public class FinalizeMethod {

	public static void main(String[] args) {
		TestFinalize t1 = new TestFinalize();
		TestFinalize t2 = new TestFinalize();
		
		//now, t1 and t2 are eligible for garbage collection
		t1=null;
		t2=null;
		
		System.gc();
		

	}

}

