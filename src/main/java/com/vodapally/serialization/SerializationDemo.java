package com.vodapally.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

class Elephant implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	public String name;
	public int age;
	public transient int weight; // can not be serialized
	@Setter
    @Getter
    private String gender; //use setter to set the value as private can not be accessed outside class
	public static String color; //static  can not be serialized
	public int num=100;


}

public class SerializationDemo {

	public static void main(String[] args) {
		Elephant e = new Elephant();
		e.age = 12;
		e.name = "Rocky";
		e.weight = 1024;
		Elephant.color = "black";
		e.setGender("Male");
		
		try {
			String filePath = "G:\\core-java-workspace-2025\\src\\main\\java\\com\\vodapally\\serialization\\elephant.ser";

			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(e);
			oos.close();
			fos.close();
			System.out.println("Serialized successfully..");
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
