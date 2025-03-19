package com.vodapally.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class AIClass {
    private static AtomicInteger count = new AtomicInteger(0);

    public AIClass() {
        System.out.println("AIClass default constructor called..");
        count.getAndIncrement();
    }

    public static AtomicInteger getCount() {
        return count;
    }
}

public class CountObjectsCreated {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            executorService.submit(() -> {
                for (int j = 1; j <= 5; j++) {
                    AIClass obj = new AIClass();
                }
            });
        }
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();

        AtomicInteger objs = AIClass.getCount();
        System.out.println("Objects Created:  = " + objs);


    }
}
