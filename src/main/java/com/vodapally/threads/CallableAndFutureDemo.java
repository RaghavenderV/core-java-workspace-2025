package com.vodapally.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureDemo {

    public static void main(String[] args) {

        List<String> stockSymbols = Arrays.asList("WIP", "HCL", "IBS", "INF", "TCS");
        List<Future> futures = new ArrayList<>(); // to add the future result

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //submit each task(that is list->stockSymbols) to executorService
        for (String stock : stockSymbols) { // 5 tasks
            StockPriceFetcherTask stockPriceFetcherTask = new StockPriceFetcherTask(stock);
            Future<Double> future = executorService.submit(stockPriceFetcherTask);
            //System.out.println(future);
            futures.add(future); // add each result(future) to list
        }

        executorService.shutdown();

        //print the result
        for (int i = 0; i < 5; i++) {
            try {
                while (!futures.get(i).isDone()) { //wait if it is not done
                    System.out.println("Waiting...");
                    Thread.sleep(2000);
                }
                System.out.println("Price for the stock " + stockSymbols.get(i) + " is : " + futures.get(i).get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}

class StockPriceFetcherTask implements Callable<Double> {

    private String stockSymbol;

    public StockPriceFetcherTask(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }


    //here is my business logic - returns some random value
    @Override
    public Double call() throws Exception {
        Thread.sleep(5000);
        return Math.random() * 1000;
    }
}
