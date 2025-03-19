package com.vodapally.interfaces;
/*
* Author@ Raghavender Vodapally
* Date@ Sep 17, 2017
*/

//marker interface
interface Permission{
	
}

class User implements Permission{
	public void show() {
		System.out.println("User: show()");
	}
}
public class MarkerInterfaceUsage {

	public static void main(String[] args) {
		User obj = new User();
		
		if(obj instanceof Permission) {
			obj.show();
		}
		else {
			System.out.println("Sorry .. you do not have permission..");
		}
	}
}

/*
A marker interface in Java is an interface that has no methods or fields declared within it.
It acts as a tag or a flag to indicate that a class implementing it has some specific property, behavior, or capability.

Why Use Marker Interfaces?
Simplicity: They provide a clean way to mark a class without requiring additional method implementations.
JVM or Framework Integration: They enable built-in functionality (e.g., serialization or cloning) without extra code.
Design Intent: They communicate a specific intent or capability to developers and tools.
 */
