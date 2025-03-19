package com.vodapally.designpatterns;

public class BreakSingletonUsingCloning {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;

        try {
            instance2 = (Singleton)instance1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Instance 1 hashCode: " + instance1.hashCode());
        System.out.println("Instance 2 hashCode: " + instance2.hashCode());

        System.out.println("Are they the same instance? " + (instance1 == instance2));

    }
}

/*
To prevent Cloning:
Either don't implement Cloneable
Or override clone() to throw an exception:
 */
