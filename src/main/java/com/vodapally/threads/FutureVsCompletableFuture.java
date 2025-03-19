package com.vodapally.threads;

import java.util.concurrent.*;

public class FutureVsCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //callFuture();

        callCompletableFuture();

    }

    private static void callCompletableFuture() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                return "Hello From CompletableFuture!!";
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, executorService);

        System.out.println("Task submitted, doing other things...");

        // Non-blocking: Define what happens when it completes
        completableFuture.thenAccept(result -> {
            System.out.println(result);
        }).exceptionally(throwable -> {
            System.err.println("Error: " + throwable.getMessage());
            return null;
        });

        System.out.println("This prints immediately, no blocking!");

        // Keep the program alive to see the async result
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void callFuture() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit a task that returns a result after 2 seconds
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000); // Simulate work
                return "Hello From Future!";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Task submitted, waiting for result...");

        // Blocking call to get the result
        String result = future.get(); // Waits until the task completes
        System.out.println(result);

        executorService.shutdown();
    }
}
/*
https://grok.com/chat/54a201a5-156b-44d0-a79a-bf79c4e52792
Future Overview
Future (introduced in Java 5) represents the result of an asynchronous computation.
It’s a basic mechanism to retrieve a result when it’s ready, but it has limitations—like no direct way to chain tasks or handle completion manually.

CompletableFuture Overview
CompletableFuture (introduced in Java 8) builds on Future and adds powerful features for composing, chaining, and handling asynchronous tasks.
It’s more modern and flexible, allowing you to explicitly complete it, handle exceptions, and combine multiple futures.

Key Differences
1. Blocking vs. Non-Blocking:
Future: future.get() blocks the thread until the result is available, which can halt your program’s flow.
CompletableFuture: Offers non-blocking methods like thenAccept() or thenApply() to handle results asynchronously.

2.Chaining Operations:
Future: No built-in way to chain tasks. You’d need to manually submit another Future based on the result.
CompletableFuture: Supports chaining with methods like thenApply(), thenCompose(), or thenCombine():

completableFuture.thenApply(result -> result.toUpperCase())
                .thenAccept(System.out::println);
3. Manual Completion:
Future: Cannot be completed manually; it’s tied to the task’s execution.
CompletableFuture: Can be completed manually with complete():

CompletableFuture<String> cf = new CompletableFuture<>();
cf.complete("Manual result!");

4. Exception Handling:
Future: Exceptions are wrapped in ExecutionException and only accessible via get().
CompletableFuture: Provides exceptionally() or handle() to deal with errors elegantly.
 */