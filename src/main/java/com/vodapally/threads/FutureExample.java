package com.vodapally.threads;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        // create a thread pool with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // define a Callable task that returns a result
        Callable<String> task = ()->{
            Thread.sleep(2000); //simulate a long-running task
            return "Task completed";
        };

        // Submit the task to the executor and get a Future object
        Future<String> future = executor.submit(task);

        // Perform other operations while the task is running
        System.out.println("Doing other work ...");

        try {
            // Wait for the task and get the result
            String result = future.get(); // blocks until the task is complete
            System.out.println("result from the task: " + result);
        }
        catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        finally {
            executor.shutdown();
        }
    }
}
