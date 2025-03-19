package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

record Person(int id, String name, int age) {
	
}

public class PersonSorting {

	public static void main(String[] args) {
		
		List<Person> list = Arrays.asList(new Person(101, "anil", 21),
										  new Person(109, "vamshi", 32),
										  new Person(199, "durga", 28),
										  new Person(189, "abhishek", 51),
										  new Person(119, "soujnya", 44));

		System.out.println("\n**************** Sort By Name **********************");
		//sort by name with using Collections.sort - method-1
		Collections.sort(list,Comparator.comparing(Person::name));
		list.forEach(System.out::println);
		
		
		System.out.println("\n**************** Sort By Age **********************");
		//sort by age with streams sorted - method-2
		list.stream().sorted(Comparator.comparing(Person::age)).forEach(System.out::println);

		System.out.println("\n**************** Get min age **********************");
		Person person = list.stream().min(Comparator.comparing(Person::age)).get();
		System.out.println("minimum age of person : "+person.age());


	}

}
