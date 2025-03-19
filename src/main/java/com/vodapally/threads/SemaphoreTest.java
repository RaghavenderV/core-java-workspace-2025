package com.vodapally.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

class LoginQueueUsingSemaphore {
    private Semaphore semaphore;

    LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    public boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    public void logout() {
        semaphore.release();
    }

    public int availableSlots() {
        return semaphore.availablePermits();
    }
}


public class SemaphoreTest {
    public static void main(String[] args) {
        int slots = 10;
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
        ExecutorService executorService = Executors.newFixedThreadPool(slots);

        IntStream.rangeClosed(1, 10).forEach(user -> executorService.execute(loginQueue::tryLogin));
        executorService.shutdown();

        System.out.println("Available slots: " + loginQueue.availableSlots());
        System.out.println("Try Login: " + loginQueue.tryLogin());
    }
}
