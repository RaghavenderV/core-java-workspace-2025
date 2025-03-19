package com.vodapally.designpatterns;

enum Singleton1{
    INSTANCE;

    // Your methods here
    public void doSomething() {
        System.out.println("Doing something");
    }
}
public class SingletonUsingEnum {
    public static void main(String[] args) {
        Singleton1 singleton = Singleton1.INSTANCE;
        singleton.doSomething();
    }
}
// A more secure Singleton implementation (using enum - recommended approach):
/*
The enum approach is considered the most secure because:

It prevents reflection attacks (JVM handles enum instantiation)
It provides serialization safety by default
It prevents cloning by default
It ensures thread safety
It's simpler to implement
 */