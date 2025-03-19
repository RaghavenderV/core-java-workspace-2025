package com.vodapally.threads;
class SharedResource{
    private static int counter = 0;

    //static synchronized method
    public static synchronized void increment(){
        counter++;
        System.out.println("Increment Counter: "+counter);
    }
    //static synchronized block
    public static void decrement(){
        synchronized (SharedResource.class) {
            counter--;
            System.out.println("Decrement Counter: " + counter);
        }
    }
}
public class StaticSynchronized {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                SharedResource.increment();
            }
        });
        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                SharedResource.decrement();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join(); // to ensure that main thread waits for their completion
    }
}
/*
Lock on Class Object: Static synchronization locks on the Class object,
ensuring that only one thread can execute any static synchronized method or block at a time.
 */