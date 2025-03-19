package com.vodapally.designpatterns;

import java.io.Serial;
import java.io.Serializable;

class Singleton implements Serializable, Cloneable {
    // The single instance of the class
    private static Singleton instance;

    // private constructor to prevent instantiation from outside
    private Singleton(){
        if (instance != null) {
            // to prevent from Reflection
            throw new RuntimeException("Use getInstance() method to get the single instance.");
        }
    }

    // public method to get the instance
    public static synchronized Singleton getInstance(){
        // create the instance if it doesn't exist (lazy initialization)
        if (instance == null){
            instance=new Singleton();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton class can not be cloned");
    }

    @Serial
    private Object readResolve(){
        return instance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
public class SingletonDesign {
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        //Singleton singleton3 = new Singleton(); // you can not instantiate with 'new'.

        // Both references point to the same instance
        singleton1.showMessage();

        // Prove they're the same instance
        System.out.println("Are they the same instance? " + (singleton1 == singleton2));
    }
}
