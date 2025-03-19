package com.vodapally.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create an ExecutorService to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Create a CompletableFuture that runs asynchronously
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started in thread: " + Thread.currentThread().getName());
            // Simulate a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, World!";
        }, executorService);

        // Attach a callback to handle the result when it's ready
        future.thenAccept(result -> {
            System.out.println("Task completed. Result: " + result);
            System.out.println("Callback executed in thread: " + Thread.currentThread().getName());
        });

        // Shutdown the executor service
        executorService.shutdown();

        // Wait for the future to complete (for demonstration purposes)
        future.get(); // This blocks the main thread until the future is complete
    }
}