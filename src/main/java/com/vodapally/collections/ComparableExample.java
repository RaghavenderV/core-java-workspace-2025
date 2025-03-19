package com.vodapally.collections;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author RAGHAVENDER
 */
@AllArgsConstructor
class Student implements Comparable<Student> {
	int rollNo;
	String name;
	int age;

	//sort students by age
	@Override
	public int compareTo(Student student) {
		return Integer.compare(this.age,student.age);
	}

}

public class ComparableExample {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<>();

		studentList.add(new Student(101, "Raghu", 28));
		studentList.add(new Student(125, "Nani", 17));
		studentList.add(new Student(116, "Charan", 32));
		studentList.add(new Student(213, "Abhi", 17));
		studentList.add(new Student(354, "Ram", 64));

		//sorting based on age
		Collections.sort(studentList);

		Iterator<Student> iterator = studentList.iterator();

		System.out.println("Sorted based on student age");
		/*
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.rollNo + " " + student.name + " "
					+ student.age);
		}*/
		
		//using java8
		studentList.stream().forEach(student-> System.out.print(student.rollNo + " " + student.name + " "
				+ student.age+"\n"));

	}

}
