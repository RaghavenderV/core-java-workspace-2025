package com.vodapally.networking;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 22, 2017
 */
@AllArgsConstructor
class Person{
	public String name;
	public int age;
	
}

class NamesCompare implements Comparator<Person>{
	@Override
	public int compare(Person p1, Person p2) {
		return p1.name.compareTo(p2.name);
	}
}

class AgeCompare implements Comparator<Person>{
	@Override
	public int compare(Person p1, Person p2) {
		return (p1.age - p2.age);
	}
}
public class SortTextFile {

	public static void main(String[] args) throws IOException {

		String inputFilePath = "G:\\core-java-workspace-2025\\src\\main\\java\\com\\vodapally\\networking\\input.txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
		
		ArrayList<Person> personRecords = new ArrayList<>();
		
		String currentLine = reader.readLine();
		
		while(currentLine!=null){
			String[] personDetails = currentLine.split(" ");
			String name = personDetails[0];
			int age = Integer.valueOf(personDetails[1]);
			
			personRecords.add(new Person(name, age));
			
			currentLine = reader.readLine();
		}
		
		Collections.sort(personRecords, new AgeCompare());

		String outputFilePath = "G:\\core-java-workspace-2025\\src\\main\\java\\com\\vodapally\\networking\\output.txt";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
		
		//Writing every record into output text file
		for(Person person: personRecords){
			writer.write(person.name);
			writer.write(" " + person.age);
			writer.newLine();
		}
		
		reader.close();
		writer.close();
		
		System.out.println("Sorting is done successfully. Please check: G:\\core-java-workspace-2025\\src\\main\\java\\com\\vodapally\\networking\\output.txt");

	}

}

