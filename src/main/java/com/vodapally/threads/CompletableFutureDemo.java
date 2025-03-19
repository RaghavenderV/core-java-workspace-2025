package com.vodapally.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
//https://www.geeksforgeeks.org/completablefuture-in-java/
public class CompletableFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> greetings = CompletableFuture.supplyAsync(() ->{
			String s1 = "Hello!Hyderabad";
			return s1;
		});
		
		System.out.println(greetings.get());
		
		
		System.out.println("\n***************************************");
		//result from multiple CompletableFuture instances
		
		CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> "Hello!");
		CompletableFuture<String> blrFuture = CompletableFuture.supplyAsync(() -> "Bengaluru!!");
		
		//now combine
		
		CompletableFuture<String> combineFuture = helloFuture.thenCombine(blrFuture, (res1, res2) -> res1+" "+res2);
		
		System.out.println(combineFuture.get());
		
		System.out.println("\n***************************************");
		//Handle exceptions
		CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
			if (true){
				throw new RuntimeException("Something went wrong!!");
			}
			return "Success!";
		}).exceptionally(throwable -> {
			System.out.println("Error occurred: "+throwable.getMessage());
			return "Recovered result";
		});

		//System.out.println("Result -> "+future.get());
		
	}

}
