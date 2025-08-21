package com.completedsa.java.javaAdvanced.javaThreads;

/*
 * Differences between "extending" and "implementing" Threads
 * When a class extends the Thread class, you cannot extend any other class
 * By implementing the Runnable interface, it is possible to extend from another class as well
 */
public class JavaThreadsImpl implements Runnable{
    public static int amount = 0;

    @Override
    public void run() {
        System.out.println("This code is running in a thread");
    }

    public static void main(String[] args) {
        JavaThreadsImpl obj = new JavaThreadsImpl();
        Thread thread = new Thread(obj);
        thread.start();

        // Use isAlive() to prevent concurrency problems
        // Wait for the thread to finish
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }

        System.out.println("This code is outside of the thread");
        // Update amount and print its value
        System.out.println("Main: " + amount);
        amount++;
        System.out.println("Main: " + amount);
    }
}
