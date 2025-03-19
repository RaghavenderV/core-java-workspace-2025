package com.vodapally.java8;

import com.vodapally.common.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindHighestPaidEmployee {

	public static void main(String[] args) {
		
		//Find highest paid employee in each dept.
		List<Employee> employees =    Arrays.asList(new Employee(101, "Haneesh", 76000L, "IT"),
													new Employee(102, "Vihaan", 65000L, "IT"),
													new Employee(201, "Sudeep", 45000L, "Accoouts"),
													new Employee(202, "Abhinav", 99000L, "Accoouts"),
													new Employee(301, "Raghu", 89000L, "HR"),
													new Employee(302, "Akshay", 69000L, "HR"));
		
		Map<String, List<Employee>> groupByEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getDept));
		System.out.println("Group By Employees : \n");
		System.out.println(groupByEmployees);
		
		Map<String, Employee> highestPaidEmployeeByDept = employees.stream()
																.collect(Collectors.groupingBy( Employee::getDept,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingLong(Employee::getSalary)), Optional::get)));
		
		System.out.println("\nHighestPaidEmployeeInEachDept : \n");
		System.out.println(highestPaidEmployeeByDept);
		
		System.out.println("---------------------------------------");
		
		Optional<Employee> highestPaidEmployee = employees.stream().collect(Collectors.maxBy(Comparator.comparingLong(Employee::getSalary)));
		System.out.println("\nHighest Paid Employee details in All the Departments: \n"+highestPaidEmployee.get());
		
		System.out.println("---------------------------------------");
		String empName = highestPaidEmployee.map(Employee::getName).get();
		System.out.println("\nHighest Paid Employee Name in All the Departments: \n"+empName);
																		

	}

}
