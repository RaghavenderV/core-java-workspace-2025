package com.vodapally.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                System.out.println("Task executed by thread : "+Thread.currentThread().getName());
            });
        }

        while (!executorService.isTerminated()){
            executorService.shutdown();
        }
    }
}
/*
This example creates a fixed thread pool with 4 threads and submits 10 tasks to it.
Each task prints the name of the thread executing it.
Finally, it shuts down the thread pool gracefully.
 */
