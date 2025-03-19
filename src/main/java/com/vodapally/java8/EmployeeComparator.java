package com.vodapally.java8;

import com.vodapally.common.Employee;
import com.vodapally.common.StaticDatabase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeComparator {

	public static void main(String[] args) {

		// first approach
		System.out.println("Employees sorted by name");
		List<Employee> list = StaticDatabase.loadEmployeeData();
		Collections.sort(list, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
		list.stream().forEach(emp -> System.out.println(emp));
		System.out.println("----------------------------");

		// second approach
		System.out.println("\n\nEmployees sorted by salary");
		List<Employee> list1 = StaticDatabase.loadEmployeeData();
		list1.stream().sorted((emp1, emp2) -> (int) (emp1.getSalary() - emp2.getSalary()))
				.forEach(System.out::println);
		System.out.println("----------------------------");

		// third approach
		System.out.println("\n\nEmployees sorted by dept");
		List<Employee> list2 = StaticDatabase.loadEmployeeData();
		list2.stream().sorted(Comparator.comparing(Employee::getDept))
				.forEach(emp -> System.out.println(emp));
		System.out.println("----------------------------");
	}

}
