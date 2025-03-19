package com.vodapally.exceptions;

class SuperClass{
    public SuperClass(int value) throws IllegalArgumentException{
        if (value<0){
            throw new IllegalArgumentException("Value can not be negative.");
        }
        System.out.println("SuperClass initialized with value: " + value);
    }
}

class SubClass extends SuperClass{
    public SubClass(int value) throws IllegalArgumentException{
        super(value);
        System.out.println("SubClass initialized..");
    }
}
public class ConstructorExceptionExample {
    public static void main(String[] args) {
        try {
            SubClass obj = new SubClass(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: "+e.getMessage());
        }
    }
}
/*
Explanation:
The SuperClass constructor throws an IllegalArgumentException if the value is negative.
The SubClass constructor calls super(value) and must declare throws IllegalArgumentException because it’s a checked exception inherited from the superclass constructor.
In main, the exception is caught when a negative value is passed.
 */