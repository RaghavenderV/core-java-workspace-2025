package com.vodapally.threads;

class Counter{
    private int count = 0;

//    public synchronized void increment(){ //test without syncronized
//        count++;
//    }

    //synchronized block
    public void increment(){
        synchronized (this){
            count++;
        }
    }
    public int getCount(){
        return count;
    }

}
public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < 5000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < 5000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join(); // to ensure that main thread waits for their completion

        System.out.println("Counter: "+counter.getCount());
    }
}
