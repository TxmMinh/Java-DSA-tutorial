package com.completedsa.dsa.algorithms.dynamicProgramming;

/**
 * Dynamic Programming is a commonly used algorithmic technique used to optimize recursive solutions when same subproblems are called again.
 *  The core idea behind DP is to store solutions to subproblems so that each is solved only once.
 *  To solve DP problems, we first write a recursive solution in a way that there are overlapping subproblems in the recursion tree (the recursive function is called with the same parameters multiple times)
 *  To make sure that a recursive value is computed only once (to improve time taken by algorithm), we store results of the recursive calls.
 *  There are two ways to store the results, one is top down (or memoization) and other is bottom up (or tabulation).
 */
public class DynamicProgramming {
    // Brute Force Approach: To find the nth Fibonacci number using a brute force approach, you would simply add the (n-1)th and (n-2)th Fibonacci numbers.
    public static int fibonacci(int n) {
        // The time complexity of the approach is exponential O(2^n)
        System.out.println("Computing F(" + n + ")");
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * To design an algorithm for a problem using Dynamic Programming, the problem we want to solve must have these two properties:
     *   - Overlapping Subproblems: The same subproblems are solved repeatedly in different parts of the problem.
     *   - Optimal Substructure: We use the optimal results of subproblems to achieve the optimal result of the bigger problem.
     */
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(n));
        // There are 25 computations, with the same computations done many times, even for just finding the 6th Fibonacci number.
    }
}
