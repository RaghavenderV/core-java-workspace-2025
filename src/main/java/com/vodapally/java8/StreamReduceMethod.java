package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//https://www.geeksforgeeks.org/stream-reduce-java-examples/?ref=rp
public class StreamReduceMethod {

	public static void main(String[] args) {
		// creating a list of Strings 
        List<String> words = Arrays.asList("GFG", "Geeks", "for", 
                                           "GeeksQuiz", "GeeksforGeeks"); 
  
        // The lambda expression passed to 
        // reduce() method takes two Strings 
        // and returns the longer String. 
        // The result of the reduce() method is 
        // an Optional because the list on which 
        // reduce() is called may be empty.
        
        Optional<String> longestString = words.stream().reduce((word1, word2) -> 
        									word1.length()>word2.length()?word1:word2);

        longestString.ifPresent(System.out::println);
	}

}
/*
reduce operation applies a binary operator to each element in the stream where the first argument 
to the operator is the return value of the previous application and second argument is the current stream
 element.
 */
