package com.completedsa.dsa.algorithms.dynamicProgramming;

/**
 * In the bottom-up approach, also known as tabulation, we start with the smallest subproblems and gradually build up to the final solution.
 *  We write an iterative solution (avoid recursion overhead) and build the solution in bottom-up manner.
 *  We use a dp table where we first fill the solution for base cases and then fill the remaining entries of the table using recursive formula.
 *  We only use recursive formula on table entries and do not make recursive calls.
 */
public class Tabulation {
    // Time Complexity: O(n)
    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];

        // Storing the independent values in dp
        dp[0] = 0;
        System.out.println("Computing F(" + 0 + ")");
        dp[1] = 1;
        System.out.println("Computing F(" + 1 + ")");

        // Using the bottom-up approach
        for (int i = 2; i <= n; i++) {
            System.out.println("Computing F(" + i + ")");
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(n));
        // Computing F(0)
        // Computing F(1)
        // Computing F(2)
        // Computing F(3)
        // Computing F(4)
        // Computing F(5)
        // Computing F(6)
        // -> Bottom-up approach
    }
}
