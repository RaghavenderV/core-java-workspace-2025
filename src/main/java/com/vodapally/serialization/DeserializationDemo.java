package com.vodapally.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationDemo {
	public static void main(String[] args) {
		Elephant e = null;

		try {
			String filePath = "G:\\core-java-workspace-2025\\src\\main\\java\\com\\vodapally\\serialization\\elephant.ser";
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			e = (Elephant) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("Deserialized Elephant Object");
		System.out.println("Name : " + e.name);
		System.out.println("Age : " + e.age);
		System.out.println("Weight : " + e.weight + " -> I am a transient variable");
		System.out.println("Color : " + e.color + " -> I am a static variable");
		System.out.println("Gender : " + e.getGender());
		System.out.println("Num : " + e.num);

	}

}
