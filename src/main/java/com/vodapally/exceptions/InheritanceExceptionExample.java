package com.vodapally.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent{
    public void display() throws IOException{
        System.out.println("Parent display method");
    }
}

class Child extends Parent{
    @Override
    public void display() throws FileNotFoundException { // Overriding method with a narrower exception (FileNotFoundException is a subclass of IOException)
        System.out.println("Child display method");
    }
}
public class InheritanceExceptionExample {
    public static void main(String[] args) {
        Parent parent = new Child(); // Polymorphism
        try {
            parent.display();
        } catch (IOException e) {
            System.out.println("Caught Exception : "+e.getMessage());
        }
    }
}

/*
Explanation:
The Parent class method declares IOException.
The Child class overrides it and throws a narrower FileNotFoundException (valid).
If Child tried to throw a broader exception (e.g., Exception), it would result in a compile-time error.
 */