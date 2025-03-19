package com.vodapally.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorWithRunnable {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task2 = () -> System.out.println("Running task2");

        task1();

        //run this task after 5 seconds, non block for task3
        scheduledExecutorService.schedule(task2,5, TimeUnit.SECONDS);

        task3();

        scheduledExecutorService.shutdown();

    }

    private static void task1() {
        System.out.println("Running task1..");
    }
    private static void task3() {
        System.out.println("Running task3..");
    }

}
