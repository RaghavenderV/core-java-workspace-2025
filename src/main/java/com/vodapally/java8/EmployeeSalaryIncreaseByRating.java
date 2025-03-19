package com.vodapally.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSalaryIncreaseByRating {

	public static void main(String[] args) {
		List<IBSEmployee> list = new ArrayList<>();
		list.add(new IBSEmployee(101, "Haneesh", 59000, 'A'));
		list.add(new IBSEmployee(102, "Durga", 28000, 'B'));
		list.add(new IBSEmployee(103, "Ramesh", 85900, 'C'));
		list.add(new IBSEmployee(104, "Prashanthi", 48900, 'A'));
		list.add(new IBSEmployee(105, "Navya", 30000, 'A'));
		list.add(new IBSEmployee(106, "Raghu", 26000, 'A'));
		list.add(new IBSEmployee(107, "Srikanth", 97000, 'B'));
		list.add(new IBSEmployee(108, "Vihann", 37000, 'C'));

		List<IBSEmployee> ratingAList = list.stream()
									.filter(emp -> Character.toString(emp.getRating()).equals("A"))
									.map(emp -> {
										emp.setSalary(emp.getSalary() * 0.1+emp.getSalary());
										return emp;
									}).collect(Collectors.toList());

		ratingAList.forEach(System.out::println);

	}

}

class IBSEmployee {
	private int id;
	private String name;
	private double salary;
	private char rating;

	public IBSEmployee() {

	}

	public IBSEmployee(int id, String name, double salary, char rating) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.rating = rating;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public char getRating() {
		return rating;
	}

	public void setRating(char rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "IBSEmployee [id=" + id + ", name=" + name + ", salary=" + salary + ", rating=" + rating + "]";
	}

}
