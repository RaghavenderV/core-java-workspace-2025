package com.vodapally.threads;

class BankAccount {
    private static double balance = 1000.00; // Shared static resource
    private static int transactionCount = 0;

    // Static synchronized method
    public static synchronized void withdraw(double amount, String threadName) {
        System.out.println(threadName + " is checking balance: " + balance);
        if (balance >= amount) {
            try {
                Thread.sleep(1000); // Simulating some processing time
                balance = balance - amount;
                transactionCount++;
                System.out.println(threadName + " withdrew amount: " + amount + ", new balance: " + balance);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Insufficient funds!!");
        }
    }

    // Using synchronized block with class object
    public static void deposit(double amount, String threadName) {
        synchronized (BankAccount.class) {
            balance = balance + amount;
            transactionCount++;
            System.out.println(threadName + " deposited amount: " + amount + ", new balance: " + balance);
        }
    }

    // Static synchronized method
    public double getBalance() {
        return balance;
    }

}

// Thread class to simulate concurrent transactions
class TransactionThread extends Thread {
    String name;

    public TransactionThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (name.contains("Withdraw")) {
            BankAccount.withdraw(500.00, name);
        } else {
            BankAccount.deposit(300.00, name);
        }
    }
}

// Main class to test the synchronization
public class StaticSyncExample {
    public static void main(String[] args) {

        // Create multiple threads to simulate concurrent access
        TransactionThread t1 = new TransactionThread("Thread1-Withdraw");
        TransactionThread t2 = new TransactionThread("Thread2-Deposit");
        TransactionThread t3 = new TransactionThread("Thread3-Withdraw");

        t1.start();
        t2.start();
        t3.start();

    }
}

/*
Key points about this example:

Static Synchronized Methods:
withdraw() and getBalance() are declared with the synchronized keyword
When a thread accesses these methods, it acquires a lock on the class itself (BankAccount.class)
Only one thread can execute any static synchronized method at a time
Synchronized Block:
The deposit() method uses a synchronized block with BankAccount.class as the lock object
This achieves the same effect as a synchronized method but provides more flexibility
Shared Resource:
balance and transactionCount are static variables shared across all instances
Without synchronization, concurrent access could lead to race conditions


Benefits of static synchronization:

Prevents race conditions when multiple threads access shared static resources
Ensures thread-safe operations on class-level data
Maintains data consistency across all instances
Common use cases:

Singleton pattern implementation
Static counter variables
Shared resource management
Configuration updates
 */