package com.vodapally.garbagecollection;

class SampleObject{
    private String name;

    public SampleObject(String name){
        this.name = name;
        System.out.println(name + " created.");
    }

}
public class GarbageCollectionExample {
    public static void main(String[] args) {
        // Creating objects
        SampleObject obj1 = new SampleObject("Object 1");
        SampleObject obj2 = new SampleObject("Object 2");

        // Making objects eligible for garbage collection
        obj1 = null;  // obj1 is now eligible for GC
        obj2 = null;  // obj2 is now eligible for GC

        // Requesting JVM to run Garbage Collector (not guaranteed)
        System.gc();

        // Adding a small delay to observe GC (for demo purposes)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main method completed");
    }
}

