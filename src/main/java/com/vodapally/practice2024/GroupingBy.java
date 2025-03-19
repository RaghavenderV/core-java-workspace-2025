package com.vodapally.practice2024;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Employee(int id, String name, int age) {
	
}
public class GroupingBy {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee(101, "Raghu", 41),
											new Employee(102, "Praveen", 30),
											new Employee(103, "Haneesh", 20),
											new Employee(104, "Rajesh", 41),
											new Employee(105, "Prashanthi", 30),
											new Employee(106, "Swetha", 26),
											new Employee(107, "Padma", 20),
											new Employee(108, "Vihaan", 41),
											new Employee(109, "Sriakanth", 30));
		
		//Group Employees By Age - method-1
		/**
		Map<Integer,List<Employee>> map = list.stream()
				.collect(Collectors.groupingBy(employee -> employee.age()));//returns map with age as key and listOfEmployees as value
		
		map.forEach((age, listOfEmployees) -> {
			System.out.println("Age : "+age);
			System.out.println("List Of Employees : "+listOfEmployees);
		});
		*/

		//method-2
		list.stream().collect(Collectors.groupingBy(Employee::age))
			.forEach((age, listOfEmployees) -> {
			System.out.println("Age : "+age);
			System.out.println("List Of Employees : "+listOfEmployees);
		});
		
		
	}

}
