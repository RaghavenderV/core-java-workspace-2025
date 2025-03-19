package com.vodapally.collections;

import lombok.Data;
import java.util.Arrays;
import java.util.Comparator;

@Data
class MphasiSEmployee {
	private int age;
	private String name;
	private long salary;

}

class AgeComparator implements Comparator<MphasiSEmployee> {
	@Override
	public int compare(MphasiSEmployee emp1, MphasiSEmployee emp2) {
		
		return (Integer.compare(emp1.getAge(), emp2.getAge()));
	}
}

class NameComparator implements Comparator<MphasiSEmployee> {
	@Override
	public int compare(MphasiSEmployee emp1, MphasiSEmployee emp2) {
		String emp1Name = emp1.getName();
		String emp2Name = emp2.getName();

		return emp1Name.compareTo(emp2Name);
	}
}

class SalaryComparator implements Comparator<MphasiSEmployee>{

	@Override
	public int compare(MphasiSEmployee emp1, MphasiSEmployee emp2) {
		
		return (int)(emp1.getSalary() - emp2.getSalary());
	}
	
}

public class ComparatorDemo {

	public static void main(String[] args) {

		MphasiSEmployee[] employee = new MphasiSEmployee[3];

		employee[0] = new MphasiSEmployee();
		employee[0].setAge(30);
		employee[0].setName("Vandana");
		employee[0].setSalary(10025);

		employee[1] = new MphasiSEmployee();
		employee[1].setAge(26);
		employee[1].setName("Shruthi");
		employee[1].setSalary(18026);

		employee[2] = new MphasiSEmployee();
		employee[2].setAge(32);
		employee[2].setName("Archana");
		employee[2].setSalary(480214);

		System.out.println("Order of employee before sorting : ");

		display(employee);

		System.out.println();

		// Sorting array on the basis of employee age by passing AgeComparator

		Arrays.sort(employee, new AgeComparator());
		System.out.println("Order of employee after sorting by Employee Age: ");

		display(employee);

		// Sorting array on the basis of employee name by passing NameComparator
		System.out.println();
		Arrays.sort(employee, new NameComparator());

		System.out.println("Order of employee after sorting by Employee Name: ");

		display(employee);
		
		// Sorting array on the basis of employee salary by passing SalaryComparator
		Arrays.sort(employee, new SalaryComparator());
		System.out.println("\nOrder of employee after sorting by Employee Salary : ");
		display(employee);
	}

	private static void display(MphasiSEmployee[] employee) {
		for (int i = 0; i < employee.length; i++) {
			System.out.println("Employee " + (i + 1) + " :: Name : "
					+ employee[i].getName() + " ; Age : "
					+ employee[i].getAge() + " ; Salary : "
					+ employee[i].getSalary());

		}
		

	}
}
