package com.vodapally.designpatterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BreakSingletonUsingSerialization {
    public static void main(String[] args) {

        try {
            Singleton instance1 = Singleton.getInstance();
            //Serialize
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            oos.writeObject(instance1);
            oos.close();

            // Deserialize
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
            Singleton instance2 = (Singleton) ois.readObject();
            ois.close();

            System.out.println("Instance 1 hashCode: " + instance1.hashCode());
            System.out.println("Instance 2 hashCode: " + instance2.hashCode());

            System.out.println("Are they the same instance? " + (instance1 == instance2));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

/*
To prevent Serialization:
@Serial
    private Object readResolve(){
        return instance;
    }
 */
