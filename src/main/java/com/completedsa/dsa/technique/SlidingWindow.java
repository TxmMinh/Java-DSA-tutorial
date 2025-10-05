package com.completedsa.dsa.technique;

/**
 * Sliding Window Technique is a method used to solve problems that involve subarray or substring or window.
 */
public class SlidingWindow {
    // Maximum Sum of a Subarray with K Elements
    static int maxSum(int[] arr, int n, int k) {
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        // Compute sums of remaining windows by removing first element of previous window and adding last element of current window.
        int windowSum = maxSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args){
        int arr[] = {5, 2, -1, 0, 3};
        int k = 3;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}
