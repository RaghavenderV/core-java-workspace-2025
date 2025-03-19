package com.vodapally.java17;

import java.util.Objects;

// Define a record named 'Person' with two components: name and age
record Person(String name, int age) {

    // You can optionally add custom methods or constructors
    public Person {
        Objects.requireNonNull(name);
        Objects.requireNonNull(age);
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
    //We can also create new constructors with different arguments by supplying a different argument list
    public Person(String name){
        this(name,21);
    }

    // methods in record
    public String greeting(){
        return "Welcome Mahakumbha Mela 2025";
    }

}

public class RecordExample {
    public static void main(String[] args) {
        // Create an instance of the Person record
        Person person = new Person("Vihaan", 10);
        System.out.println(person.greeting()); // call greeting

        Person customPerson = new Person("Haneesh");
        System.out.println("customPerson = " + customPerson);

        // Access the components using automatically generated getter methods
        System.out.println("Name: " + person.name()); // Output: Name: Alice
        System.out.println("Age: " + person.age());   // Output: Age: 30

        // Use the automatically generated toString() method
        System.out.println(person); // Output: Person[name=Alice, age=30]

        // Use the automatically generated equals() method
        Person anotherPerson = new Person("Alice", 30);
        System.out.println("Are they equal? " + person.equals(anotherPerson)); // Output: Are they equal? true

        // Use the automatically generated hashCode() method
        System.out.println("HashCode: " + person.hashCode()); // Output: HashCode: <some integer value>
    }
}
