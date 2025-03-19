package com.vodapally.logics;
/*
* Author@ Raghavender Vodapally
* Date@ Feb 6, 2018
*/
//https://www.youtube.com/watch?v=4VBdNbWeTZw
//Encapsulation : Binding data with methods
//Why we need it? 
//We have to make sure our data is safe
//we can also make log file
class GovtStudent{
	private int rollno;
	private String name;
	
	//setters and getters
	public int getRollno() {
		System.out.println("user is accessing the value");
		//we can also check the login of the user here
		return rollno;
	}
	public void setRollno(int rollno) {
		System.out.println("value of roll number changed");
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

public class EncapsulationDemo {

	public static void main(String[] args) {
		
		GovtStudent student = new GovtStudent();
		student.setRollno(101);
		student.setName("Mallesh");
		
		System.out.println("Student Roll Number: "+student.getRollno());
		System.out.println("Student Roll Name:   "+student.getName());

	}

}

//we can make variables public and create object and directly assign values.
//student.rollno=101
//but this is not a good approach
