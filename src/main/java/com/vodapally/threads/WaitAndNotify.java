package com.vodapally.threads;

// Print Letters and Numbers in below sequence
//A 1 B 2 C 3 D 4 E 5 F 6 G 7 H 8 I 9 J 10 K 11 L 12 M 13 N 14 O 15 P 16 Q 17 R 18 S 19 T 20 U 21 V 22 W 23 X 24 Y 25 Z 26
public class WaitAndNotify {
    private static boolean printLetter = true;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Runnable letterTask = () -> {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                synchronized (lock) {
                    if (!printLetter) { // if it is not your turn, then wait
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }//if
                    System.out.print(ch + " "); //this is your turn, print now.
                    printLetter = false; // change the condition
                    lock.notify();
                }
            }
        };

        Runnable numberTask = () -> {
            for (int i = 1; i <= 26; i++) {
                synchronized (lock) {
                    if (printLetter) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(i + " ");
                    printLetter = true;
                    lock.notify();
                }
            }
        };

        Thread letterThread = new Thread(letterTask);
        Thread numberThread = new Thread(numberTask);

        letterThread.start();
        numberThread.start();

        try {
            letterThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            System.out.println("Exception due to : ");
        }

    }
}
/*
wait() -> causes the current thread to pause its execution and releases the associated monitor(lock)
until another thread invokes notify() or notifyAll() for the same object.

 */