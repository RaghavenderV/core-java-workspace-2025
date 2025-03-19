package com.vodapally.threads;

import java.util.concurrent.*;

public class ScheduledExecutorWithCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Callable<Integer> task2 = () -> 99;
        task1();
        //run this task after 5 seconds, non block for task3, returns a future
        ScheduledFuture<Integer> future = ses.schedule(task2, 5, TimeUnit.SECONDS);
        task3();

        //block and get the result
        System.out.println("Result: "+future.get());
        System.out.println("Shut down!");
        ses.shutdown();

    }
    private static void task1() {
        System.out.println("Running task1..");
    }
    private static void task3() {
        System.out.println("Running task3..");
    }
}
