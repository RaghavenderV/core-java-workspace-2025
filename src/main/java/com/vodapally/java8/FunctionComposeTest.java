package com.vodapally.java8;

import com.vodapally.common.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionComposeTest {

	public static void main(String[] args) {
		// Employee emp = new Employee();

		Function<Employee, String> empNameFun = e -> e.getName();

		Function<Employee, Employee> empFirstNameFun = e -> {
			int index = e.getName().indexOf(" ");
			String firstName = e.getName().substring(0, index);
			e.setName(firstName);
			return e;
		};

		// prepare list of employees
		List<Employee> employeeList = Arrays.asList(new Employee(101, "Raghavender Vodapally"),
				new Employee(102, "Haneesh Vodapally"), new Employee(103, "Mounika Apuri"),
				new Employee(104, "Shirisha Racharla"), new Employee(105, "Prabhas Raju"));

		List<String> empFirstNameList = convertEmployeeListToFirstNameList(employeeList,
				empNameFun.compose(empFirstNameFun));

		System.out.println("Employees First Name List");
		System.out.println("--------------------------");
		empFirstNameList.forEach(fn -> System.out.println(fn));
	}

	public static List<String> convertEmployeeListToFirstNameList(List<Employee> employeeList,
			Function<Employee, String> funEmployeeToString) {

		List<String> empNameList = new ArrayList<>();

		for (Employee emp : employeeList) {

			empNameList.add(funEmployeeToString.apply(emp));
		}

		return empNameList;
	}

}

/*
 * 1. List of employees having id and name. 2. Name contains FirstName LastName
 * (Raghavender Vodapally) (Haneesh Vodapally) (Moounika Apuri) 3. Get List of
 * Strings with first name only
 */
