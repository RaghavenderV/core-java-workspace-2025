package com.vodapally.threads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Submit tasks to the executor service
        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            executorService.submit(()->{
                // Each thread will put some values into the map
                for (int j = 0; j < 100; j++) {
                    String key = "key-" + threadId + "-" + j;
                    map.put(key, j); // write operation
                    Integer i1 = map.get(key);// read operation
                    //System.out.println("Thread " + threadId + " added " + key);
                    System.out.println(Thread.currentThread().getName()+ " added " + key);
                    System.out.println(Thread.currentThread().getName()+ " retrieved: " + i1);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        // Print the final size of the map
        System.out.println("Final map size: " + map.size());
    }
}
