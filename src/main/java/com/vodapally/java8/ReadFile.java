package com.vodapally.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

	public static void main(String[] args) {

		String fileName = "G://core-java-workspace-2025/src/main/resources/nameslist.txt";

		List<String> list = new ArrayList<>();
		// read file into stream, try with resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			//stream.forEach(System.out::println); //prints all data
			
			//1. Filter line 3 (Kajal)
			//2. Convert to upper case
			//3. Convert to List
			list = stream.filter(str -> !str.startsWith("Kajal"))
					.map(String::toUpperCase)
					.toList();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list.forEach(System.out::println);
	}

}
