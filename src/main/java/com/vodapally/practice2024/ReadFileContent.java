package com.vodapally.practice2024;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class ReadFileContent {

	public static void main(String[] args) throws InterruptedException {
		String filePath = "G://core-java-workspace-2025/src/main/resources/readme.txt";
		
		StringBuilder content = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line;
			
			while((line = reader.readLine())!=null) {
				content.append(line).append("\n");
			}
			
			System.out.println(content);
			
			
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}

}
