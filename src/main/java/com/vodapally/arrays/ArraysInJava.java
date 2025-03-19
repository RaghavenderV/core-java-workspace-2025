package com.vodapally.arrays;

class UserDefinedType{
	int i=66;
	
	void methodOne(){
		System.out.println("From UserDefinedType Object");
	}
}

public class ArraysInJava {

	public static void main(String[] args) {
		UserDefinedType[] arrayOfDefinedTypeObjects = new UserDefinedType[10];
		
		for(int i=0; i<arrayOfDefinedTypeObjects.length; i++){
			//Creating an object of 'UserDefinedType' and
			//assigning it to an element of array
			arrayOfDefinedTypeObjects[i] = new UserDefinedType();
		}
		
		System.out.println(arrayOfDefinedTypeObjects[2].i);
		
		arrayOfDefinedTypeObjects[5].methodOne();

	}

}
