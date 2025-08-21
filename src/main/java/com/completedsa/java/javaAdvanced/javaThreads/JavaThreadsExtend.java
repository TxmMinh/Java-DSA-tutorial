package com.completedsa.java.javaAdvanced.javaThreads;

/*
 * Threads allows a program to operate more efficiently by doing multiple things at the same time.
 * Threads can be used to perform complicated tasks in the background without interrupting the main program.
 */
public class JavaThreadsExtend extends Thread {
    public static int amount = 0;

    @Override
    public void run() {
        amount++;
        System.out.println("This code is running in a thread");
    }

    public static void main(String[] args) {
        JavaThreadsExtend thread = new JavaThreadsExtend();
        thread.start();

        System.out.println("This code is outside of the thread");

        /*
         * Concurrency Problems
         * Because threads run at the same time as other parts of the program, there is no way to know in which order the code will run.
         * When the threads and main program are reading and writing the same variables, the values are unpredictable
         */
        System.out.println(amount);
        amount++;
        System.out.println(amount);
    }

}
