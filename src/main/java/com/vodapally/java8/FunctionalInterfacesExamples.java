package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesExamples {

	public static void main(String[] args) {
		
		// find length of name and multiply by 2
		// Function is a functional interface; it takes an argument (objectof type T) 
		// and returns an object (object of type R).The argument and output can be a
		// different type. Function has apply and andThen methods
		
		System.out.println("**************Function*************************");
		String name = "Raghu";
		Function<String, Integer> lengthOfName = x -> x.length();
		Function<Integer, Integer> mulBy2 = x -> x * 2;

		// first finds length of name and then apply mulBy2
		Integer result = lengthOfName.andThen(mulBy2).apply(name);
		System.out.println("Result : " + result);
		System.out.println("**************Function*************************");
		
		
		
		System.out.println("**************Consumer*************************");

		// Consumer is a functional interface; it takes an argument and returns nothing.
		// Consumer has accept method.
		Consumer<String> consumer = str -> System.out.println("Consumer Example.." + str);
		consumer.accept(name);

		System.out.println("***************Consumer************************");

		
		
		
		// Predicate is a functional interface, which accepts an argument and returns a boolean.
		// Usually, it used to apply in a filter for a collection of objects. 
		// Predicate has test method
		System.out.println("**************Predicate*************************");

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// Predicate<Integer> evenPredicate = x -> (x % 2 == 0);
		// list.stream().filter(evenPredicate).forEach(System.out::println);
		
		// short hand for above two lines : prints even numbers
		list.stream().filter(i -> (i%2==0)).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		// Example 2
		List<String> strList = Arrays.asList("Raghu", "Rani","Ramani","Sudeep","Soma");
		
		//get all strings starting with "R"
		strList.stream().filter(s -> s.startsWith("R")).forEach(str -> System.out.print(str + " "));

		System.out.println("\n**************Predicate*************************");

		
		
		
		System.out.println("**************Supplier*************************");
		// Supplier is a functional interface; it takes no arguments and returns a result.
		String var = "Hello Supplier!";
		Supplier<String> supplier = () -> var;
		System.out.println(supplier.get());
		System.out.println("**************Supplier*************************");
		
		
		
	}

}
