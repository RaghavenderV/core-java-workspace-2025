package com.vodapally.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsToMapExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");

		Map<String, Integer> map = list.stream().collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(map);
		
		System.out.println("---------------------------------------\n");
		List<LTIEmployee> employeeList = new ArrayList<>();
		employeeList.add(new LTIEmployee(1, "One", 20));
		employeeList.add(new LTIEmployee(2, "Two", 30));
		employeeList.add(new LTIEmployee(3, "Three", 40));
		employeeList.add(new LTIEmployee(4, "Four", 25));
		employeeList.add(new LTIEmployee(5, "Give", 35));
		employeeList.add(new LTIEmployee(5, "Giver", 95));//duplicate key as per emp id
		
		
		Map<Integer, LTIEmployee> empTreeMap = employeeList.stream().collect(Collectors.toMap(LTIEmployee::getId, 
										Function.identity(),
										(oldVal,newVal)->newVal,
										TreeMap::new));
		System.out.println(empTreeMap);
	}

}

class LTIEmployee{
	private int id;
	private String name;
	private int age;
	
	public LTIEmployee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LTIEmployee other = (LTIEmployee) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
