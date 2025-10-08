package com.completedsa.dsa.algorithms.greedyAlgorithm;

import java.util.Arrays;

/**
 * A greedy algorithm solves problems by making the best choice at each step.
 * Instead of looking at all possible solutions, it focuses on the option that seems best right now.
 * Most of the problems where greedy algorithms work follow these two properties:
 *      Greedy Choice Property: This property states that choosing the best possible option at each step will lead to the best overall solution. If this is not true, a greedy approach may not work.
 *      Optimal Substructure: This means that you can break the problem down into smaller parts, and solving these smaller parts by making greedy choices helps solve the overall problem.
 * Dynamic programming also works when a problem has optimal substructure but it also requires Overlapping Subproblems.
 */
public class GreedyAlgorithm {
    /**
     * Example:Let's say you have a set of coins with values [1, 2, 5, 10] and you need to give minimum number of coin to someone change for 39.
     */
    public static int minCoins(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int res = 0;

        // Start from the coin with highest denomination
        for (int i = n - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                // Find the maximum number of ith coin we can use
                int count = amount / coins[i];
                // Add the count to result
                res += count;

                // Subtract the corresponding amount from the total amount
                amount -= (count * coins[i]);
            }

            // Break if there is no amount left
            if (amount == 0) {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] coins = {5, 2, 10, 1};
        int amount = 39;

        System.out.println(minCoins(coins, amount));

        /**
         * The greedy algorithm is not always the optimal solution for every optimization problem.
         *  The greedy approach fails to find the optimal solution in case make change for the amount 20 with the coin denominations [18, 1, 10].
         *  Although it uses three coins, a better solution would have been to use two 10 coins.
         */
    }
}
