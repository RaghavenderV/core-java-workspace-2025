package com.vodapally.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOddPrinterByTwoThreads {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10).forEach(num -> {
            CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(num)
                    .thenApplyAsync(x -> {
                        if (x % 2 != 0) {
                            System.out.println("Thread name: " + Thread.currentThread().getName() + " : " + x);
                        }
                        return num;
                    }, executorService); //thenApplyAsync

            oddCompletableFuture.join();

            CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(num).thenApplyAsync(
                    x -> {
                        if (x % 2 == 0) {
                            System.out.println("Thread name: " + Thread.currentThread().getName() + " : " + x);
                        }
                        return num;
                    }, executorService);

            evenCompletableFuture.join();
        });

        executorService.shutdown();
    }
}

/*
The join() method is used to retrieve the result of a CompletableFuture when it completes, blocking the current thread if necessary until the result is available. It’s similar to the get() method but with a key difference:
join() doesn’t throw a checked exception like get() does.

thenApplyAsync() is a method in CompletableFuture that takes the result of a completed CompletableFuture, applies a transformation
function to it, and returns a new CompletableFuture representing the result of that transformation

In Java, CompletableFuture.completedFuture() is a static method in the CompletableFuture class,
introduced in Java 8 as part of the java.util.concurrent package. It’s used to create a
CompletableFuture that is already completed with a specified result. This can be useful when you
want to return a pre-computed or immediate result in an asynchronous programming context without
needing to perform any actual asynchronous computation.

public static <U> CompletableFuture<U> completedFuture(U value)

How It Works
The returned CompletableFuture is in a completed state immediately upon creation.
Any subsequent calls to methods like .get(), .join(), or .thenApply() will execute immediately with the provided value (or throw an exception if an error condition arises).
It’s a convenient way to integrate synchronous results into an asynchronous workflow.
 */