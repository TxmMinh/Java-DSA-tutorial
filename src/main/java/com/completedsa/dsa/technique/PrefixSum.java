package com.completedsa.dsa.technique;

import java.util.ArrayList;

/**
 * The idea is to create an array prefixSum[] of size n, and for each index i in range 1 to n - 1,
 * set prefixSum[i] = prefixSum[i - 1] + arr[i].
 */
public class PrefixSum {
    // function to find the prefix sum array
    static ArrayList<Integer> prefixSum(int[] arr) {
        // Time Complexity: O(n)
        int n = arr.length;

        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(arr[0]);

        // For each index add the value of the current element and the previous value of the prefix sum array
        for (int i = 1; i < n; i++) {
            prefixSum.add(prefixSum.get(i - 1) + arr[i]);
        }

        return prefixSum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 5, 15};
        ArrayList<Integer> prefixSum = prefixSum(arr);
        for (int i : prefixSum) {
            System.out.print(i + " ");
        }
    }
}
