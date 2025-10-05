package com.completedsa.dsa.recursion;

public class RecursionJava {
    static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args)
    {
        // Fibonacci of 4
        System.out.println("Fibonacci of 4: " + Fibonacci(4));

        // Fibonacci of 5
        System.out.println("Fibonacci of 5: " + Fibonacci(5));
    }
}
