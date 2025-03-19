package com.vodapally.practice;

public class PermutationsOfString {

	public static void main(String[] args) {
		String s = "win";
		printAllPermutations(s,"");
		
	}

	static void printAllPermutations(String s, String result) {
		//if string is empty
		if(s.length() == 0) {
			System.out.println(result + "");
			return;
		}
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);//w
			//rest of the string after excluding the ith character
			String ros = s.substring(0,i)+s.substring(i+1);
			//in -> s.substring(0,0)+s.substring(0+1) -> returns empty string ->""+in=in ->1st iteration
			//s.substring(0,1)+s.substring(1+1) -> returns empty string ->w+n=wn ->2nd iteration
			
			//recursive call
			printAllPermutations(ros, result+ch);//in,w
		}
		
	}
	
}
