package com.vodapally.interview;

class Course implements Cloneable{
	String subject1;
	String subject2;
	String subject3;
	
	public Course(String subject1, String subject2, String subject3) {
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Student implements Cloneable{
	int id;
	String name;
	Course course;
	
	public Student(int id, String name, Course course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		Student student = (Student)super.clone();
		student.course = (Course)course.clone();
		return student;
	}
	
	
}

public class DeepCloningDemo {

	public static void main(String[] args) {
		Course computerCourse = new Course("C","Blue Prism","Java");
		Student student1 = new Student(101,"Raghu",computerCourse);
		Student student2 = null;
		
		//Creating a clone of student1 and assigning it to student2
		try {
			student2 = (Student)student1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		 //Printing the subject3 of 'student1'
        System.out.println(student1.course.subject3);
        
        //changing the subject3 of 'student2'
        student2.course.subject3 = "Maths";
        
       //This change will be reflected in original student 'student1'
        System.out.println(student1.course.subject3);       //Output : Java

	}

}
