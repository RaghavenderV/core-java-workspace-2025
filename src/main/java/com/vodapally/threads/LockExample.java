package com.vodapally.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class LockExample {
    private final Lock lock = new ReentrantLock();
    private int counter=0;

    public void increment(){
        lock.lock();
        try {
            counter++;
            System.out.println("Counter: "+counter);
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample example = new LockExample();

        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                example.increment();
            }
        });

        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                example.increment();
            }
        });

        t1.start();
        t2.start();

    }
}
//https://grok.com/chat/f4074f40-f8fa-4e09-bc29-958c0aec401d