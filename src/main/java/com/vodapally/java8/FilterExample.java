package com.vodapally.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.vodapally.common.Person;

public class FilterExample {

	public static void main(String[] args) {
		//simple filter example
		List<String> list = Arrays.asList("Java","Servlets","JSP","Springboot","Blueprism");
		List<String> collect = list.stream().filter(tech -> !"Blueprism".equals(tech)) //filter out 'Blueprism
						.collect(Collectors.toList());//collect it
		
		collect.forEach(System.out::println);
		
		//Use Person class
		List<Person> persons = Arrays.asList(new Person("Sudeep", 28, "Bhubaneswar"),
				new Person("Raghavender", 36, "Konthan pally"),
				new Person("Soma", 35, "Kolkata"));
		
		// I want only Raghavender details
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Get only Raghavender details");
		Person p = persons.stream().filter(person -> person.getName().equals("Raghavender"))
				.findAny()
				.orElse(null);
		
		System.out.println(p);
		
		//get only person name
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("get only person name - Sudeep");
		String name = persons.stream().filter(person -> person.getName().equals("Sudeep"))
						.map(Person::getName)
						.findAny()
						.orElse("");
		
		System.out.println("Name of the person : "+name);
		
		
	}

}
