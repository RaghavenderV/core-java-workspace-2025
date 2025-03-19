package com.vodapally.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExampleTest {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new RunnableTask1());
        }

        while (!executorService.isTerminated()){
            executorService.shutdown();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("I'm executed after all threads shutdown");

        System.out.println("Time taken for executing 10 jobs by 3 threads in ms : "+(endTime-startTime));

    }
}
class RunnableTask1 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=1000; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}