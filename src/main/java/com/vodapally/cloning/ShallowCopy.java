package com.vodapally.cloning;

//http://javaconceptoftheday.com/clone-method-java-lang-object-class/
/*If a cloned object and original objects are not 100% disjoint, then it is called shallow copy. 
 * In shallow copy operation, any changes made to clone will be reflected in the original or vice-versa. 
 * This happens when an object has reference variables as fields.
 * 
 */

class A {
	int i;

	public A(int i) {
		this.i = i;
	}
}

class B implements Cloneable {
	A a;

	public B(A a) {
		this.a = a;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}

public class ShallowCopy {

	public static void main(String[] args) {
		A a = new A(10);
		B b1 = new B(a);
		B b2 = null;
		

		try {
			b2 = (B) b1.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("this object does not support cloning");
		}

		System.out.println("Before Changing 'i' value: " + b1.a.i); // prints 10

		// change the i value to 999;
		b2.a.i = 999;

		System.out.println("After Changing 'i' value: " + b1.a.i); // prints 999; reflected in origianl object

	}

}
