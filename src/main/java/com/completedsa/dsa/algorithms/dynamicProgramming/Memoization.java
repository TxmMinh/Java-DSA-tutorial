package com.completedsa.dsa.algorithms.dynamicProgramming;

import java.util.Arrays;

/**
 * In the top-down approach, also known as memoization, we keep the solution recursive and add a memoization table to avoid repeated calls of same subproblems.
 *  Before making any recursive call, we first check if the memoization table already has solution for it.
 *  After the recursive call is over, we store the solution in the memoization table.
 */
public class Memoization {
    // Time Complexity: O(n)
    private static int fibonacciMemo(int n, int[] memo) {
        // To check if output already exists
        if (memo[n] != -1) {
            return memo[n];
        }

        // Print only when we actually compute a new one
        System.out.println("Computing F(" + n + ")");

        // Base case
        if (n <= 1) {
            memo[n] = n;
        } else {
            // Calculate and save output for future use
            memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        }
        return memo[n];
    }

    public static int fibonacci(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibonacciMemo(n, memo);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(n));
        // Computing F(6)
        // Computing F(5)
        // Computing F(4)
        // Computing F(3)
        // Computing F(2)
        // Computing F(1)
        // Computing F(0)
        // -> Top-down approach
    }
}
