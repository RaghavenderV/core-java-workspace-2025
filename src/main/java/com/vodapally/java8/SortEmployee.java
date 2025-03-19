package com.vodapally.java8;

import com.vodapally.common.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployee {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(101, "Raghavender", 820000L, "Information Technology"));
		list.add(new Employee(102, "Mallesh", 610000L, "Admin"));
		list.add(new Employee(103, "Abhi", 590000L, "Human Resources"));
		list.add(new Employee(104, "Prashanthi", 750000L, "Sales"));
		list.add(new Employee(105, "Vihaan", 450000L, "Finance"));
		list.add(new Employee(106, "Haneesh", 990000L, "Information Technology"));
		
		//sort employee by name
		System.out.println("Employee by name");
		System.out.println("-----------------");
		List<Employee> nameComparator = list.stream()
										.sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
										.collect(Collectors.toList());
		
		nameComparator.forEach(System.out::println);
		
		
		//other way of sorting
		System.out.println("\nEmployee by salary");
		System.out.println("-----------------");
		List<Employee> salaryComparator = list.stream()
											.sorted(Comparator.comparing(Employee::getSalary))
											.collect(Collectors.toList());
		
		salaryComparator.forEach(System.out::println);
		
	}

}
