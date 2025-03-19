package com.vodapally.oops;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class University {
    private String name;
    private Student student; // Aggregation: University "has-a" Student

    public University(String name, Student student) {
        this.name = name;
        this.student = student; // Reference to an existing Student object
    }

    public void display() {
        System.out.println("University: " + name + ", Student: " + student.getName());
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        Student student = new Student("Raghavender Vodapally"); // Student exists independently

        University university = new University("Osmania University", student);
        university.display();

        // Even if university is set to null, student still exists
        university = null;
        System.out.println("Student still exists: " + student.getName());
    }
}

/*
Aggregation:
Definition: Aggregation is a "weak" has-a relationship where one class contains a reference to another class, but the contained object can exist independently of the container. It implies a "part-of" relationship with no strict ownership.
Lifecycle: The contained object’s lifecycle is not tied to the container. If the container is destroyed, the contained object can still exist.
Example: A University and Student relationship. A university has students, but if the university shuts down, the students can still exist independently.

 Key Point: The Student object is created outside the University class and passed in, showing that Student isn’t tightly bound to University.
 */