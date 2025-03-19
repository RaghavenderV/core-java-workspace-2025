package com.vodapally.java8;

import com.vodapally.common.Employee;
import com.vodapally.common.StaticDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondHighestSalary {

	public static void main(String[] args) {
		List<Employee> list = StaticDatabase.loadEmployeeData();
		list.forEach(System.out::println);
		//Max salary
		
		Employee employee = list.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
		
		System.out.println("\n\n"+"Max salary Employee:");
		System.out.println(employee);
		
		Employee employee2 = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1)
											.findFirst().get();
		
		System.out.println("\n\n"+"Second Highest Salaried Employee");
		System.out.println(employee2);
	}

}
