package com.vodapally.logics;

import com.vodapally.common.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByExample {
	
	public static List<Employee> loadEmployeeData(){
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(101, "Raghavender", 820000L, "Information Technology"));
		list.add(new Employee(102, "Mallesh", 610000L, "Admin"));
		list.add(new Employee(103, "Raghavender", 590000L, "Human Resources"));
		list.add(new Employee(104, "Prashanth", 750000L, "Sales"));
		list.add(new Employee(105, "Raghavender", 450000L, "Finance"));
		list.add(new Employee(106, "Mallesh", 990000L, "Information Technology"));
		
		return list;
	}

	public static void main(String[] args) {
		List<String> items =Arrays.asList("apple", "apple", "banana","banana","banana",
                        					"apple", "orange", "banana", "papaya");
		
		//grouping by
		Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(result);
		
		//sorting map by value
		Map<String, Long> map = new LinkedHashMap<>();
		result.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
				.forEachOrdered(e -> map.put(e.getKey(), e.getValue()));
		
		System.out.println(map);
		
		//2.
		
		
		
		
	}

}
