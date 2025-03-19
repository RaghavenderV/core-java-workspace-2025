package com.vodapally.designpatterns;

import java.lang.reflect.Constructor;

public class BreakSingleton {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;

        try {
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instance2 = (Singleton) constructor.newInstance();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("instance1 hashCode: " + instance1.hashCode());
        System.out.println("instance2 hashCode: " + instance2.hashCode());

        System.out.println("Are they the same instance? " + (instance1 == instance2));

    }
}

/*
You can break Singleton if you are not using this in Singleton:
if (instance != null) {
        throw new RuntimeException("Use getInstance() method to get the single instance.");
    }
 */
